package com.nhnacademy.mart.servlet;

import com.nhnacademy.mart.domain.Basket;
import com.nhnacademy.mart.domain.BuyList;
import com.nhnacademy.mart.domain.Food;
import com.nhnacademy.mart.domain.FoodStand;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import javax.management.openmbean.InvalidKeyException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /**
         * GET /cart : 장바구니 화면
         * 응답에 장바구니에 담긴 상품 목록과 전체 금액 표시
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /**
         * POST /cart : 장바구니에 담기
         * 상품 수량보다 더 많은 주문을 하지 않았는 지 검증
         * 장바구니에 담은 수량만큼 상품매대에서 제거 처리
         * 응답 화면에 장바구니 화면으로 이동할 수 있는 링크 제공
         */

        StringTokenizer tokenizer = new StringTokenizer(request.getParameter("wishList")," ,");

        Map<String, Integer> foodList =
            (Map<String, Integer>) request.getServletContext().getAttribute("foodList");

        BuyList buyList = new BuyList();

        try {
            while (tokenizer.hasMoreTokens()) {
                String name = tokenizer.nextToken();
                int amount = Integer.parseInt(tokenizer.nextToken());

                if (!foodList.containsKey(name)) {
                    throw new InvalidKeyException(
                        "매대에 존재하지 않는 제품이 포함되어있습니다.\n" +
                            "제품 매대를 확인하고 다시 입력해주세요.\n");
                } else {
                    if (foodList.get(name) < amount) {
                        throw new InvalidKeyException(
                            "진열된 수량보다 더 많은 값이 입력되었습니다.\n" +
                                "제품 매대를 확인하고 다시 입력해주세요.\n");
                    } else {
                        FoodStand stand =
                            (FoodStand) request.getServletContext().getAttribute("foodStand");
                        buyList.add(new BuyList.Item(name, amount));

                        Basket basket = new Basket();
                        for (int i = 0; i < amount; i++) {
                            for (int k = 0; k < stand.getFoods().size(); ) {
                                Food food = stand.getFoods().get(k);

                                if (food.getName().equals(name)) {
                                    basket.add(food);
                                    stand.getFoods().remove(k);
                                    break;
                                } else {
                                    k++;
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().println(e.getMessage());
        }

        request.getServletContext().setAttribute("buyList",buyList);
    }
}

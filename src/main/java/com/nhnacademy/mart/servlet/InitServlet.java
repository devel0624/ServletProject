package com.nhnacademy.mart.servlet;

import com.nhnacademy.mart.domain.Food;
import com.nhnacademy.mart.domain.FoodStand;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "initServlet", urlPatterns = "/init")
public class InitServlet extends HttpServlet {

    Food[] foodList;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();

        StringTokenizer tokenizer = new StringTokenizer(
            context.getInitParameter("foods").trim(), ", \n");

        foodList = new Food[tokenizer.countTokens()/2];

        for (int i = 0; tokenizer.hasMoreTokens() ; i++) {
            String name = tokenizer.nextToken();
            int price = Integer.parseInt(tokenizer.nextToken());

            foodList[i] = new Food(name,price);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /**
         * GET /init : 식품매대 준비
         * context-param 에 설정된 식품 정보를 읽어서 식품 객체를 생성하고
         * ServletContext attribute 로 설정 → 모든 Servlet 에서 참조 가능
         */

        FoodStand stand = new FoodStand();

         for (int i = 0 ; i < foodList.length; i++){

             int value = 5 + new Random().nextInt(5);

             for(int k = 0; k < value; k++){
                stand.getFoods().add(new Food(foodList[i]));
             }
         }
         request.getServletContext().setAttribute("foodStand",stand);

         response.sendRedirect("/foods");
    }
}

package com.nhnacademy.mart.servlet;

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
    }
}

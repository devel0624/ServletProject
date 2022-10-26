package com.nhnacademy.mart.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "foodsServlet", urlPatterns = "/foods")
public class FoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /**
         * GET /foods : 상품 목록
         * 응답에 상품 목록 출력
         * 원하는 상품을 선택해서 장바구니에 담을 수 있는 form 구성
         * 생각보다 복잡할 수 있으므로 우선 상품 목록 출력을 한 다음
         * 그 이후에 장바구니에 담을 수 있는 form을 구성하는 순서로 진행을 추천
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}

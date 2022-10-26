package com.nhnacademy.mart.servlet;

import com.nhnacademy.mart.domain.Food;
import com.sun.net.httpserver.HttpContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "initServlet", urlPatterns = "/init")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /**
         * GET /init : 식품매대 준비
         * context-param 에 설정된 식품 정보를 읽어서 식품 객체를 생성하고
         * ServletContext attribute 로 설정 → 모든 Servlet 에서 참조 가능
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}

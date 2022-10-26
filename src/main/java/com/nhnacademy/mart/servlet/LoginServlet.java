package com.nhnacademy.mart.servlet;

import java.util.Objects;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "loginServlet", urlPatterns = "/login", initParams = {
    @WebInitParam(name = "id", value = "id"),
    @WebInitParam(name = "pw", value = "pw"),
})
public class LoginServlet extends HttpServlet {
    String identity;
    String password;
    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("login init");

        identity = config.getInitParameter("id");
        password = config.getInitParameter("pw");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /**
         * 로그인 / 로그아웃
         * /loginForm.html
         * GET /login
         * POST /login
         * GET /logout
         */
        HttpSession session = request.getSession(false);

        if(Objects.nonNull(session)){
            response.sendRedirect("/login.html");
        }else {
            response.sendRedirect("/loginForm.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        log.info("login doPost");
        if(identity.equals(id) && password.equals(pw)){
            HttpSession session = request.getSession();
            session.setAttribute("id",id);

            response.sendRedirect("/login");
        }else{
            response.sendRedirect("/loginFail.html");
        }
    }
}

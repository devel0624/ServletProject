package com.nhnacademy.mart.servlet;

import java.util.Objects;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(Objects.isNull(session)){
            response.sendRedirect("/loginForm.html");
        }else {
            session.invalidate();
            response.sendRedirect("/loginForm.html");
        }
    }
}

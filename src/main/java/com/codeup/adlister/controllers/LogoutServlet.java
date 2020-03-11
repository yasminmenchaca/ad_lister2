package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("login_error");
        request.removeAttribute("password_error");
        request.removeAttribute("email_error");
        request.removeAttribute("username_error");
        request.removeAttribute("password_mismatch");
        request.getSession().invalidate();
        response.sendRedirect("/login");
    }
}

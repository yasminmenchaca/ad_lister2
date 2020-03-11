package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Validate;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String  username = request.getParameter("username"),
                email = request.getParameter("email"),
                password = request.getParameter("password"),
                password_confirm = request.getParameter("password_confirm");

        HttpSession session = request.getSession();
        Validate input = new Validate();
        Boolean validation = input.authenticate(username,password,email,password_confirm,request,response);

        if (validation) {
            input.clearAttributes(request);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("email", email);
            User user = new User(
                    1,
                    request.getParameter("username"),
                    request.getParameter("email"),
                    request.getParameter("password")
            );
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
        }

    }

}

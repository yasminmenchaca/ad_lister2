package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // why are we using this?
        User user = (User) request.getSession().getAttribute("user");

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));
        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // ======== checking username, email & both for validation ======== \\
        try {
            boolean usernameAndEmailNotValid = DaoFactory.getUsersDao().validateUsername(username) && DaoFactory.getUsersDao().validateEmail(email);
            boolean usernameNotValid = DaoFactory.getUsersDao().validateUsername(username);
            boolean userEmailNotValid = DaoFactory.getUsersDao().validateEmail(email);

            if (usernameAndEmailNotValid){
                request.setAttribute("bothTaken", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (usernameNotValid) {
                request.setAttribute("usernameTaken", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (userEmailNotValid) {
                request.setAttribute("emailTaken", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        // create and save a new user
        try {
            String currentDate = DaoFactory.getAdsDao().getCurrentDate();
            System.out.println(currentDate);
            user = new User(username, email, password, currentDate);
            request.getSession().setAttribute("user", user);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
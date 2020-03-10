package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {
            request.setAttribute("accountExists", false);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        boolean passwordValid = Password.check(password, user.getPassword());

        if (passwordValid) {
            request.getSession().setAttribute("user", user);
            try {
                List<Ad> userAds = DaoFactory.getAdsDao().getUserAds(user.getId()); // List of users Ads
                request.getSession().setAttribute("userAds", userAds);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("/profile");
        } else {
            request.setAttribute("passwordMatch", false);
            System.out.println("else in passwordValid reached" + passwordValid);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
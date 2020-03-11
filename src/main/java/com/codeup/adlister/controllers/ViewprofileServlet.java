package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        String entry = user.getUsername();
        List<Ad> ads = DaoFactory.getAdsDao().profileAds(entry);
        request.setAttribute("profileAds", ads);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String emailChange = request.getParameter("emailInput");
        String passwordChange = request.getParameter("passwordInput");
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();


        if (emailChange != null && !emailChange.isEmpty()) {
            DaoFactory.getUsersDao().modifyEmail(emailChange, username);
        }


        if (passwordChange != null && !passwordChange.isEmpty()) {
            DaoFactory.getUsersDao().modifyPassword(passwordChange, username);
        }

            user = DaoFactory.getUsersDao().findByUsername(username);
            request.getSession().invalidate();
            request.getSession().setAttribute("user", user);


            response.sendRedirect("/profile");
    }
}

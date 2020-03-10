package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewprofileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;

        } else {
            User currentUser = (User) request.getSession().getAttribute("user");
            long userId = currentUser.getId();
            try {
                List<Ad> userAds = DaoFactory.getAdsDao().getUserAds(userId);
                int numberOfAds = userAds.size();
                request.setAttribute("numberOfAds", numberOfAds);
                request.removeAttribute("userAds");
                request.getSession().setAttribute("userAds", userAds);
                request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}




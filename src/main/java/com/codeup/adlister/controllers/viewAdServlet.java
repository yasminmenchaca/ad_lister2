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

@WebServlet(name = "viewAdServlet", urlPatterns = "/viewAd")
public class viewAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long adId = Long.parseLong(request.getParameter("adId"));

        try {
            Ad ad = DaoFactory.getAdsDao().createAdObject(adId);
            request.setAttribute("ad", ad);
            if (request.getSession().getAttribute("user") != null) {
                User currentUser = (User) request.getSession().getAttribute("user");
                String currentUsername = currentUser.getUsername();
                if (ad.getUsername().equals(currentUsername)) {
                    request.setAttribute("belongsToUser", true);
                }

            }
            request.getRequestDispatcher("/WEB-INF/ads/viewAd.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

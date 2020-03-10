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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String[] categories = request.getParameterValues("category");
            List<String> trimmedCategories = new ArrayList<>();
            for (String category : categories) {
                trimmedCategories.add(category.substring(0, (category.length() - 1)));
            }
            String catString = String.join(" ,", trimmedCategories);
            System.out.println(catString);
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            User user = (User) request.getSession().getAttribute("user");
            long userId = user.getId();
            String date = DaoFactory.getAdsDao().getCurrentDate();
            int adId = DaoFactory.getAdsDao().insertIntoAds(userId, title, description, date, catString);
            for (String category : categories) {
                DaoFactory.getAdsDao().insertAdCategories(adId, Integer.parseInt(category.substring(category.length() - 1)));
            }

            List<Ad> userAds = DaoFactory.getAdsDao().getUserAds(user.getId()); // List of users Ads
            request.getSession().removeAttribute("userAds");
            request.getSession().setAttribute("userAds", userAds);
            request.setAttribute("created", true);
            request.getRequestDispatcher("/WEB-INF/ads/AdUpdated.jsp").forward(request, response);

        }
//
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
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
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(name = "EditAdServlet", urlPatterns = "/ads/editAd")
public class EditAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adId = request.getParameter("ad-id");
        String titleChange = request.getParameter("titleInput");
        String descriptionChange = request.getParameter("descriptionInput");
        String deleteAd = request.getParameter("deleteAd");

        if (titleChange != null && !titleChange.isEmpty()) {
            DaoFactory.getAdsDao().titleChange(titleChange, adId);
        }

        if (descriptionChange != null && !descriptionChange.isEmpty()) {
            DaoFactory.getAdsDao().descriptionChange(descriptionChange, adId);
        }

        if (deleteAd != null && !deleteAd.isEmpty()) {
            DaoFactory.getAdsDao().deleteAd(adId);
        }

        response.sendRedirect("/profile");
    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String Ad = request.getParameter("ad-id");

        List<com.codeup.adlister.models.Ad> singleAd = DaoFactory.getAdsDao().individualAd(Ad);
        request.setAttribute("single", singleAd);
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
    }
}

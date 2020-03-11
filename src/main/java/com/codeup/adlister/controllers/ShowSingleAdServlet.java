package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowSingleAdServlet", urlPatterns = "/ads/single")
public class ShowSingleAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ad = request.getParameter("ad-id");
        List<Ad> singleAd = DaoFactory.getAdsDao().individualAd(Ad);
        request.setAttribute("single", singleAd);
        request.getRequestDispatcher("/WEB-INF/ads/singleAd.jsp").forward(request, response);
    }
}

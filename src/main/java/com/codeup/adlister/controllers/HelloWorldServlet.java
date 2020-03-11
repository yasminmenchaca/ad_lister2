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

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/home")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("<h1>Hello, World!</h1>");

        // List all ads
        request.setAttribute("all", DaoFactory.getAdsDao().all());

        // List Cars ads
        request.setAttribute("car", DaoFactory.getAdsDao().selWhile((long) 1));

        // List Sporting ads
        request.setAttribute("sports", DaoFactory.getAdsDao().selWhile((long) 8));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
// cars1
// collectibles2
// electronics3
// furniture4
// musical5
 // outdoor7
//  sporting8
//  tools9

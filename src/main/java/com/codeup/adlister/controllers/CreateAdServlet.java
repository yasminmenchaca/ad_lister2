package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 *1024 * 50)

public class CreateAdServlet extends HttpServlet {

    private String myPath = "Library/Caches/IntelliJIdea2019.3/tomcat/Tomcat_9_0_311_adlister_7/work/Catalina/localhost/ROOT/org/apache/jsp/WEB_002dINF/ads/img";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user=null;
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        Validate validate = new Validate();
        boolean validAttempt = validate.authenticate(title,description,price,request);

        // File upload variables
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fileName = request.getParameter("fileName");
        System.out.println(fileName);
        Part filePart = request.getPart("picture");
        String filename = extractFilename(filePart);
        System.out.println(filename);
        String savePath = myPath + File.separator + filename;
//        String location = String.format("%s/%s","resources/img",filename);
        System.out.println(savePath);
        String location = String.format("%s/%s","/resources/img",filename);

        if(session != null){
            user = (User) session.getAttribute("user");
        }

        if(user != null){
            if (validAttempt) {
                filePart.write(savePath + File.separator); // writing file to location
                Ad ad = new Ad(user.getId(),
                        request.getParameter("title"),
                        request.getParameter("description"),
                        request.getParameter("price"),
                        request.getParameter("category"),
                        location
                );
                DaoFactory.getAdsDao().insert(ad);
                response.sendRedirect("/profile");
            } else {
                // setting this attributes in case the makes a mistake.  User won't loose his input.
                session.setAttribute("title", title);
                session.setAttribute("description", description);
                session.setAttribute("price", price);
                response.sendRedirect("/ads/create");
            }
        }
    }

    private String extractFilename(Part filePart){
        String contentDisp = filePart.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s: items){
            if (s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=") +2 , s.length() -1);
            }
        }
        return "";
    }

}


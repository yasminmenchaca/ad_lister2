//package com.codeup.adlister.controllers;
//import com.codeup.adlister.dao.DaoFactory;
//import com.mysql.cj.jdbc.Driver;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//@WebServlet(name = "controllers.UploadServlet", urlPatterns = "/upload")
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
//maxFileSize = 1024 * 1024 * 10,
//maxRequestSize = 1024 *1024 * 50)
//
//public class UploadServlet extends HttpServlet{
//    static final String DATABASE_URL = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
//    private String myPath = "/Users/Gonzo 1/IdeaProjects/AdLister/src/main/webapp/resources/img";
//
//    @Override
//    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        String fileName = request.getParameter("fileName");
//        Part filePart = request.getPart("picture");
//        InputStream inputStream = null;
//
//        System.out.println(fileName);
//        System.out.println(filePart);
//
//        String filename = extractFilename(filePart);
//        System.out.println(filename);
//
//        String savePath = myPath + File.separator + filename;
//
//        System.out.println(savePath);
//
//        File fileSaveDir = new File(savePath);
//
//        filePart.write(savePath + File.separator);
//        try {
////            Class.forName(Driver);
//            DriverManager.registerDriver(new Driver());
//            Connection connection = DriverManager.getConnection(DATABASE_URL,"adlister_admin","admin123");
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into media(location) values(?)");
//            preparedStatement.setString(1,String.format("%s/%s","/resources/img",filename));
//            preparedStatement.executeUpdate();
//            request.setAttribute("inserted","<h3> Image inserted successfully</h3>");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String extractFilename(Part filePart){
//        String contentDisp = filePart.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String s: items){
//            if (s.trim().startsWith("filename")){
//                return s.substring(s.indexOf("=") +2 , s.length() -1);
//            }
//        }
//        return "";
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }
//        request.getRequestDispatcher("/WEB-INF/upload.jsp")
//                .forward(request, response);
//
//    }
//
//
//}
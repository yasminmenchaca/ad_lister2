package com.codeup.adlister.util;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Validate {

    public boolean authenticate (String username, String password, String email, String password_confirm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User userInput = DaoFactory.getUsersDao().findByUsername(username);
        User userEmail = DaoFactory.getUsersDao().findByEmail(email);

        String userExist = String.format("<p style=\"color:red\">username '%s' already exists.</p", username);
        String emailExist = String.format("<p style=\"color:red\">email '%s' already in use..</p", email);

        if (username == null || username.trim() == ""){
            clearAttributes(request);
            session.setAttribute("username_error",  "<p style=\"color:red\">Sorry \"username\" error!</p>");
            response.sendRedirect("/register");
            return false;
        }
        else if (password == null || password.trim() == ""){
            clearAttributes(request);
            session.setAttribute("password_error",  "<p style=\"color:red\">Sorry \"password\" error!</p>");
            response.sendRedirect("/register");
            return false;
        }
        else if (email == null || email.trim() == ""){
            clearAttributes(request);
            session.setAttribute("email_error",  "<p style=\"color:red\">Sorry \"email\" error!</p>");
            response.sendRedirect("/register?");
            return false;
        } // finish checking for
        // checking if passwords match
        else if(!password.equals(password_confirm)){
            clearAttributes(request);
            session.setAttribute("password_mismatch",  "<p style=\"color:red\">Sorry \"passwords\" do not match!</p>");
            response.sendRedirect("/register");
            return false;
        }
        // checking if username exist in DB
        else if (userInput != null){
            clearAttributes(request);
            session.setAttribute("userExist_error", userExist);
            response.sendRedirect("/register");
            return false;
        }
        else if (userEmail != null){
            response.sendRedirect("/register");
            clearAttributes(request);
            session.setAttribute("emailExist_error", emailExist);
            return false;
        } else return true;
    }

    public boolean authenticate (String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {
            clearAttributes(request);
            session.setAttribute("username_error",  "<p style=\"color:red\">Username does not exist!</p>");
            return false;
        } else if (!Password.check(password, user.getPassword())){
            clearAttributes(request);
            session.setAttribute("password_error",  "<p style=\"color:red\">Sorry \"wrong password\"!</p>");
            return false;
        } else return true;

    }

    public boolean authenticate(String title, String description, String price, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if(title == null || title.trim() == ""){
            clearAttributes(request);
            session.setAttribute("title_error",  "<p style=\"color:red\">Title cannot be empty</p>");
            return false;
        } else if(description == null || description.trim() == ""){
            clearAttributes(request);
            session.setAttribute("description_error",  "<p style=\"color:red\">Description cannot be empty</p>");
            return false;
        } else if(price == null || price.trim() == ""){
            clearAttributes(request);
            session.setAttribute("price_error",  "<p style=\"color:red\">Price cannot be empty</p>");
            return false;
        } else return true;
    }


    public void clearAttributes(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("title_error");
        session.removeAttribute("description_error");
        session.removeAttribute("price_error");
        session.removeAttribute("password_error");
        session.removeAttribute("email_error");
        session.removeAttribute("username_error");
        session.removeAttribute("password_mismatch");
        session.removeAttribute("userExist_error");
        session.removeAttribute("emailExist_error");
    }

}

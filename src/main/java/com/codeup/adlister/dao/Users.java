package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    User findByEmail(String email);
    void insert(User user);
    String hashPassword(String password);
    void modifyEmail(String email, String user);
    void modifyPassword(String password, String user );
}

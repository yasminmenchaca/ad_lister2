package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;
    private Config config = new Config();

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password, dateMade) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getDate());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("dateMade")
        );
    }

    public int updateUsername(String username, long id) {
        String query = "UPDATE users SET username = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setLong(2, id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("error on SQL Exception of updateUser method");
        }
    }


    public int updateEmail(String email, long id) throws SQLIntegrityConstraintViolationException {
        String query = "UPDATE users SET email = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setLong(2, id);

            return ps.executeUpdate();

        }catch (SQLIntegrityConstraintViolationException myError) {
            throw new SQLIntegrityConstraintViolationException("error at SQL of updateUser method");
        } catch (SQLException e) {
            throw new RuntimeException("error on SQL Exception of updateEmail method");
        }
    }

    // being throw 500 error at last point
    public int updatePassword (String password, long id) throws SQLIntegrityConstraintViolationException {
        String query = "UPDATE users SET password = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setLong(2, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
//            System.out.println(password + id);
            throw new RuntimeException("error on SQL Exception of updatePassword method");
        }
    }


    @Override
    public boolean validateUsername(String username) throws SQLException {
        boolean usernameExist = false;
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getString("username").equals(username)) {
                usernameExist = true;
            }
        }
        return usernameExist;
    }

    @Override
    public boolean validateEmail(String email) throws SQLException {
        boolean emailExist = false;
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
        String query = "SELECT * FROM users WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getString("email").equals(email)) {
                emailExist = true;
            }
        }
        return emailExist;
    }

    // we already have password check in password util... do we even need this?
    @Override
    public boolean validatePassword(String password) throws SQLException {
        boolean passwordCorrect = false;
        String query = "SELECT * FROM users WHERE password = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("this is password in while loop: " + password);
            System.out.println("passwordCorrect: " + passwordCorrect);
            if (rs.getString("password").equals(password)) {
                passwordCorrect = true;
            }
        }
        return passwordCorrect;
    }
}
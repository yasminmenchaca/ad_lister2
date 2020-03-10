package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;
    private Config config = new Config();

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT ads.id, ads.user_id, users.username, ads.title, ads.description, ads.dateMade, ads.catString\n" +
                    "FROM ads\n" +
                    "JOIN users\n" +
                    "ON users.id = ads.user_id;");
            ResultSet rs = stmt.executeQuery();
            List<Ad> allAds = new ArrayList<>();
            while (rs.next()) {
                Ad newAd = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("username"),
                        rs.getString("dateMade"),
                        rs.getString("catString")
                );
                allAds.add(newAd);
            }
            return allAds;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> selWhile(Long catId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT ads.id, ads.user_id, users.username, ads.title, ads.description, ads.dateMade, ads.catString, adCategories.category_id \n" +
                    "FROM ads\n" +
                    "JOIN users\n" +
                    "ON users.id = ads.user_id\n" +
                    "JOIN adCategories\n" +
                    "ON adCategories.ad_id = ads.id\n" +
                    "WHERE category_id = " + catId + ";");
            ResultSet rs = stmt.executeQuery();
            List<Ad> allAds = new ArrayList<>();
            while (rs.next()) {
                Ad newAd = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("username"),
                        rs.getString("dateMade"),
                        rs.getString("catString"),
                        rs.getLong("category_id")
                );
                allAds.add(newAd);
            }
            return allAds;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, dateMade, catString) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getDateMade());
            stmt.setString(5, ad.getCatString());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("dateMade"),
                rs.getString("catString")
        );
    }

    @Override
    public List<Ad> getUserAds(Long id) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
        String query = "SELECT * FROM ads WHERE user_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();
        List<Ad> userAds = new ArrayList<>();
        while (rs.next()) {
            Ad ad = extractAd(rs);
            userAds.add(ad); // inserts each add created the user made to List

        }
        return userAds;
    }


    @Override
    public String getCurrentDate() throws SQLException {
        String query = "SELECT CURRENT_DATE AS date";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getString("date");
    }

    @Override
    public int insertIntoAds(long user_id, String title, String description, String date, String categories) throws SQLException {
        String query = "INSERT INTO ads (user_id, title, description, dateMade, catString) VALUES (? ,? ,?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, user_id);
        ps.setString(2, title);
        ps.setString(3, description);
        ps.setString(4, date);
        ps.setString(5, categories);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public int insertAdCategories(long ad_id, long cat_id) throws SQLException {
        String query = "INSERT INTO adCategories (ad_id, category_id) VALUES (? ,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, ad_id);
        ps.setLong(2, cat_id);
        return ps.executeUpdate();
    }

    @Override
    public Ad createAdObject(long ad_id) throws SQLException {
        String query = "SELECT *, users.username FROM ads\n" +
                "JOIN users\n" +
                "ON users.id = ads.user_id\n" +
                "WHERE ads.id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, ad_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Ad newAd = new Ad(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("username"),
                rs.getString("dateMade"),
                rs.getString("catString")
        );
        return newAd;
    }

    @Override
    public int updateAd(String title, String description, long ad_id) throws SQLException {
        String query = "UPDATE ads SET title = ?, description =  ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, title);
        ps.setString(2, description);
        ps.setLong(3, ad_id);
        return ps.executeUpdate();
    }

    @Override
    public int deleteAdFromAdTable(long ad_id) throws SQLException {
        String query = "DELETE FROM ads WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, ad_id);
        return ps.executeUpdate();
    }

    public int deleteAdFromAdCategories(long ad_id) throws SQLException {
        String query = "DELETE FROM adCategories WHERE ad_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, ad_id);
        return ps.executeUpdate();
    }

    public List<Ad> findAdByKeyword(String keyword) throws SQLException {
        String query = "SELECT *, users.username FROM ads\n" +
                "JOIN users\n" +
                "ON users.id = ads.user_id\n" +
                "WHERE ads.title LIKE ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        List<Ad> keywordAds = new ArrayList<>();
        while (rs.next()) {
            Ad newAd = new Ad(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("username"),
                    rs.getString("dateMade"),
                    rs.getString("catString")
            );
            keywordAds.add(newAd);

        }
        return keywordAds;
    }
}
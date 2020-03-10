package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // Select on Category id
    List<Ad> selWhile(Long catId);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // list Ad Objects User made
    List<Ad> getUserAds(Long id) throws SQLException;

    int insertIntoAds(long user_id, String title, String description, String date, String categories) throws SQLException;

    String getCurrentDate() throws SQLException;

    int insertAdCategories(long ad_id, long cat_id) throws SQLException;

    Ad createAdObject(long ad_id) throws SQLException;

    int updateAd(String title, String description, long ad_id) throws SQLException;

    int deleteAdFromAdTable(long ad_id) throws SQLException;

    int deleteAdFromAdCategories(long ad_id) throws SQLException;
    List<Ad> findAdByKeyword(String keyword) throws SQLException;




}
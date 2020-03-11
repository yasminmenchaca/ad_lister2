      delete user_id, title, description, price, location, ads_id,
      categories_id, media_id, ad_id
 from ads
 join pivot_categories
   on ads.id = pivot_categories.ads_id
 join pivot_media
   on ads.id = pivot_media.ad_id
 join media
   on pivot_media.media_id = media.id
where ads.id               = 2;







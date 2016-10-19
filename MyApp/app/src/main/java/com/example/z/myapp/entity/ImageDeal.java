package com.example.z.myapp.entity;

/**
 * load pic from internet
 */

public class ImageDeal {
    private static String[] banner_images;
    private static String[] circle_images;
    private static String[] recommend_images;
    private static String[] hot_images;

    private volatile static ImageDeal imageDeal;

    private ImageDeal() {
    }

    public static ImageDeal getImageDeal() {
        if (imageDeal == null) {
            synchronized (ImageDeal.class) {
                if (imageDeal == null) {
                    imageDeal = new ImageDeal();
                }
            }
        }
        return imageDeal;
    }


    static String banner_img1 = "http://img1.3lian.com/2015/w7/98/d/101.jpg";
    static String banner_img2 = "http://img1.3lian.com/2015/w7/98/d/101.jpg";
    static  String banner_img3 = "http://img1.3lian.com/2015/w7/98/d/101.jpg";
    static  String banner_img4 = "http://img1.3lian.com/2015/w7/98/d/101.jpg";
    static  String banner_img5 = "http://img1.3lian.com/2015/w7/98/d/101.jpg";

    static  String recommend_img1 = "http://img.taopic.com/uploads/allimg/140811/235050-140Q10H53683.jpg";
    static  String recommend_img2 = "http://photocdn.sohu.com/20160202/Img436669543.jpg";
    static  String recommend_img3 = "http://photocdn.sohu.com/20160202/Img436669543.jpg";
    static  String recommend_img4 = "http://photocdn.sohu.com/20160202/Img436669543.jpg";


    public static void setBanner_img1(String banner_img1) {
        ImageDeal.banner_img1 = banner_img1;
    }

    public static String getBanner_img1() {
        return banner_img1;
    }

    public String[] getBanner_images() {
        banner_images = new String[]{banner_img1, banner_img2, banner_img3, banner_img4, banner_img5};
        return banner_images;
    }

    public String[] getRecommend_images() {
        recommend_images = new String[]{recommend_img1, recommend_img2, recommend_img3, recommend_img4};
        return recommend_images;
    }

    public  void setBanner_images(String[] banner_images)
    {
        this.banner_img1 = banner_images[0];
        this.banner_img2 = banner_images[1];
        this.banner_img3 = banner_images[2];
        this.banner_img4 = banner_images[3];
        this.banner_img5 = banner_images[4];
    }

    public  void setCircle_images(String[] circle_images) {
        ImageDeal.circle_images =circle_images;
    }

    public static void setRecommend_images(String[] recommend_images) {
        ImageDeal.recommend_images = recommend_images;
    }

    public void setHot_images(String[] hot_images) {
        this.hot_images = hot_images;
    }
}

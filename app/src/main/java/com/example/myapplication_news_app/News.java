package com.example.myapplication_news_app;

import android.util.EventLogTags;

public class News {

    private String title;
    private String newsImage;

    private String newsdescription;

    public News(){
    }
    public News(String title, String newsImage,String newsdescription ){
        this.title = title;
        this.newsImage = newsImage;
        this.newsdescription = newsdescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsdescription() {
        return newsdescription;
    }

    public void setNewsdescription(String newsdescription) {
        this.newsdescription = newsdescription;
    }

}

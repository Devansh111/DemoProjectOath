package com.example.devansh.demoprojectoath.PoJo;

/**
 * Created by Devansh on 8/21/2018.
 */

public class NewsPojo {

    String title;
    String image;
    String web_url;
    String id;

    public NewsPojo(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}

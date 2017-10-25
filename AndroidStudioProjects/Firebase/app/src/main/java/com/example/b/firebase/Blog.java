package com.example.b.firebase;

/**
 * Created by b on 22/3/17.
 */

public class Blog {
    private String title;
    private String description;
    private String image;
    private String name;
    public Blog() {
    }
    public Blog(String image,String name) {

        this.image = image;
        this.name=name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

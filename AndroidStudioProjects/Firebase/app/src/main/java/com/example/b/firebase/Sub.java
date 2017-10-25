package com.example.b.firebase;

/**
 * Created by b on 24/3/17.
 */

public class Sub {

    public String name;

    public String image;


    public Sub() {
    }
    public Sub(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

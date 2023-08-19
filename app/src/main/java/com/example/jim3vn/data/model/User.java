package com.example.jim3vn.data.model;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private int birth;
    private List<Medal> medals;
    private String traits;
    private String image;

    public User(String id, String name, String email, int birth, String traits) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.traits = traits;
    }

    public User(String id, String name, String email, int birth, List<Medal> medals, String traits, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.medals = medals;
        this.traits = traits;
        this.image = image;
    }

    public User(String id, String name, String email, int birth, String traits, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.traits = traits;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }


    public String gettraits() {
        return traits;
    }

    public void settraits(String traits) {
        this.traits = traits;
    }
}

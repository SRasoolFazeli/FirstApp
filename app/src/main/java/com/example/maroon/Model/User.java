package com.example.maroon.Model;

import com.google.gson.annotations.SerializedName;

public class User {


    @SerializedName("uid")
    private String uid;

    @SerializedName("id")
    private String id;

    @SerializedName("city")
    private String city;

    @SerializedName("phone")
    private String phone;


    @SerializedName("email")
    private String email;


    @SerializedName("f_name")
    private String name;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

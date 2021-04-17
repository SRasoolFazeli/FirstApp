package com.example.maroon.Responses;

import com.example.maroon.Model.User;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status_code")
    public int status_code;

    @SerializedName("auth_token")
    public String auth_token;

    @SerializedName("user")
    public User user;
}



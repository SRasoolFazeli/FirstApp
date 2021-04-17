package com.example.maroon.Responses;

import android.content.Context;
import android.content.SharedPreferences;

// Session manager to save and fetch data from SharedPreferences

public class SessionManager {
    public String USER_TOKEN = "user_token";
    private Context context;
    private SharedPreferences prefs;

    public SessionManager(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    }

    //save Auth Token
    public void saveAuthToken(String token) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_TOKEN, token);
        editor.apply();
    }

    //fetch Token
    public String fetchAuthToken (){
        return prefs.getString(USER_TOKEN , null);
    }
}

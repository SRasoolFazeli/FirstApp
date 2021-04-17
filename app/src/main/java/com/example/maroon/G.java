package com.example.maroon;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.Toast;

public class G extends Application {

    public static Context context;
    public static Typeface Font_shabnam ,Font_shabnam_bold,Font_shabnam_medium,Font_shabnam_light ;


    @Override
    public void onCreate() {
        context = getApplicationContext();
        Font_shabnam =Typeface.createFromAsset(context.getResources().getAssets(), "fonts/shabnam.ttf");
        Font_shabnam_bold =Typeface.createFromAsset(context.getResources().getAssets(), "fonts/shabnam_bold.ttf");
        Font_shabnam_medium =Typeface.createFromAsset(context.getResources().getAssets(), "fonts/shabnam_medium.ttf");
        Font_shabnam_light =Typeface.createFromAsset(context.getResources().getAssets(), "fonts/shabnam_light.ttf");
        super.onCreate();

    }

    public static void showToast(String data) {
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }

}

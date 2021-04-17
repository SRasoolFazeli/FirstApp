package com.example.maroon.Responses;

import android.content.Context;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private Context context ;
    private SessionManager sessionManager ;

    public AuthInterceptor(Context context) {
        this.context = context;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        sessionManager = new SessionManager(context) ;
        Request.Builder requestBuilder = chain.request().newBuilder();

        String token = sessionManager.fetchAuthToken();
        if (token != null){
            requestBuilder.addHeader("Authorization", "Bearer "+ token);
        }
        return chain.proceed(requestBuilder.build());
    }

}



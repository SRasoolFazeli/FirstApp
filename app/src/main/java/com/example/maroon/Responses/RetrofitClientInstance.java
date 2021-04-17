package com.example.maroon.Responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.maroon.G;

public class RetrofitClientInstance {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://";

    public static Retrofit getClient() {
        if(retrofit==null){

            Gson gson = new GsonBuilder().setLenient().create();
            OkHttpClient.Builder client = new OkHttpClient.Builder();

            client.addInterceptor(new AuthInterceptor(G.context));

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

    public static ApiService GetServiceClass(){
        return RetrofitClientInstance.getClient().create(ApiService.class);
    }

}



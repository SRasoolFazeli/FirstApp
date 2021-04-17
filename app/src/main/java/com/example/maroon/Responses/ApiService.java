package com.example.maroon.Responses;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("api/login")
    Call<LoginResponse> Login(@Query("email") String email ,@Query("password") String password );

//    @POST("api/register")
//    Call<RegisterResponse> Register(@Header("Authorization") String token , @Query("f_name") String name , @Query("city") String city);
//
}


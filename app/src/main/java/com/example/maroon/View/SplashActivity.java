package com.example.maroon.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.maroon.R;
import com.example.maroon.Responses.LoginResponse;
import com.example.maroon.Responses.RetrofitClientInstance;
import com.example.maroon.Responses.SessionManager;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.maroon.G.Font_shabnam;

public class SplashActivity extends AppCompatActivity {


    private TextInputLayout tilName;
    private TextInputLayout tilPhoneNumber;
    private TextInputEditText edtName;
    private TextInputEditText edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        login();
    }

    //Cast and Set TypeFace for Views
    private void init() {
        tilName = findViewById(R.id.tilName);
        tilPhoneNumber = findViewById(R.id.tilPhoneNumber);
        edtName = findViewById(R.id.edtName);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);

        tilName.setTypeface(Font_shabnam);
        tilPhoneNumber.setTypeface(Font_shabnam);
        edtName.setTypeface(Font_shabnam);
        edtPhoneNumber.setTypeface(Font_shabnam);
    }

    //login and save token
    private void login() {
        RetrofitClientInstance.GetServiceClass().Login("R@Yahoo.com", "123").enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (loginResponse.status_code == 200 & loginResponse.user != null) {
                    SessionManager sessionManager = new SessionManager(SplashActivity.this);
                    sessionManager.saveAuthToken(loginResponse.auth_token);
                } else {
                    //Error
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // Error logging in
            }
        });
    }
}
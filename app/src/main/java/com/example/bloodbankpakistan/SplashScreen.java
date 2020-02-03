package com.example.bloodbankpakistan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                    startActivity(new Intent(getApplicationContext(),RegistrationPage.class));
                    finish();
                } catch (Exception e) {
                }
            }
        };
        background.start();
    }
}

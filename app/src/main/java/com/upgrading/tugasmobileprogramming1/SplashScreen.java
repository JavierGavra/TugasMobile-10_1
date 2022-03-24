package com.upgrading.tugasmobileprogramming1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int SplashTime = 1876;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toMainPage = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(toMainPage);
                SplashScreen.this.finish();
            }
        }, SplashTime);

    }
}
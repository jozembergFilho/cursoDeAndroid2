package com.example.berg.projetocarros_berg;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.logging.Handler;

public class SplashScreen extends AppCompatActivity implements Runnable {

    private static int DELAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ocultarBarraDeNavegação();

        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(this,DELAY);

    }

    @Override
    public void run() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) private void ocultarBarraDeNavegação(){
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions); }
}

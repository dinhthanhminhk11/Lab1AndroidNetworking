package com.example.lab1androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab1androidnetworking.Activity.Bai1MainActivity;
import com.example.lab1androidnetworking.Activity.Bai3MainActivity;
import com.example.lab1androidnetworking.Activity.Bai4MainActivity;
import com.example.lab1androidnetworking.Activity.SplashscreenActivity;

public class MainActivity extends AppCompatActivity {
    private Button bai1;
    private Button bai2;
    private Button bai3;
    private Button bai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bai1 = (Button) findViewById(R.id.bai1);
        bai2 = (Button) findViewById(R.id.bai2);
        bai3 = (Button) findViewById(R.id.bai3);
        bai4 = (Button) findViewById(R.id.bai4);

        bai1.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , Bai1MainActivity.class));
        });
        bai2.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , SplashscreenActivity.class));
        });
        bai3.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , Bai3MainActivity.class));
        });
        bai4.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , Bai4MainActivity.class));
        });

    }


}
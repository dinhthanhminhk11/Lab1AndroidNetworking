package com.example.lab1androidnetworking.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1androidnetworking.Action.ImageListener;
import com.example.lab1androidnetworking.Action.ImageLoader;
import com.example.lab1androidnetworking.R;

public class Bai2MainActivity extends AppCompatActivity {

    private ImageView image;
    private TextView message;
    private Button loadImage;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 2");
        image = (ImageView) findViewById(R.id.image);
        message = (TextView) findViewById(R.id.message);
        loadImage = (Button) findViewById(R.id.loadImage);
        progressDialog = new ProgressDialog(this);
        final Handler handler = new Handler();
        loadImage.setOnClickListener(v -> {
            String link = "https://images.pexels.com/photos/1525041/pexels-photo-1525041.jpeg?auto=compress&cs=tinysrgb&w=600";
            ImageLoader loader = new ImageLoader();
            loader.setImageListener(new ImageListener<Bitmap>() {
                @Override
                public void start() {
                    message.setText("Loading ...");
                }

                @Override
                public void finish(Bitmap o) {
                    progressDialog.dismiss();
                    image.setImageBitmap(o);
                    message.setText("Load successful");
                }
            });
            loader.execute(link);
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
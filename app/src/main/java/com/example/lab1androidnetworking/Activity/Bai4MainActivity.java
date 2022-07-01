package com.example.lab1androidnetworking.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1androidnetworking.Action.ImageListener;
import com.example.lab1androidnetworking.Action.ImageLoader;
import com.example.lab1androidnetworking.R;

public class Bai4MainActivity extends AppCompatActivity {

    private EditText sleep;
    private Button runAsyntask;
    private TextView message;
    ProgressDialog progressDialog;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 4");

        sleep = (EditText) findViewById(R.id.sleep);
        runAsyntask = (Button) findViewById(R.id.runAsyntask);
        message = (TextView) findViewById(R.id.message);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        final Handler handler = new Handler();
        runAsyntask.setOnClickListener(v -> {
            time = sleep.getText().toString().trim();
            String link = "https://images.pexels.com/photos/1379636/pexels-photo-1379636.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
            ImageLoader loader = new ImageLoader();
            loader.setImageListener(new ImageListener<Bitmap>() {
                @Override
                public void start() {
                    progressDialog.show();
                    progressDialog.setMessage("ProgressDialog");
                    progressDialog.setMessage("ProgressDialog in load " + time + " second");
                    Runnable progressRunnable = new Runnable() {

                        @Override
                        public void run() {
                            progressDialog.cancel();
                            message.setText("successful");
                            sleep.setText("");
                        }
                    };

                    Handler pdCanceller = new Handler();
                    pdCanceller.postDelayed(progressRunnable, Integer.parseInt(time) * 1000);
                    message.setText("Sleeping");
                }

                @Override
                public void finish(Bitmap o) {
//                    progressDialog.dismiss();
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
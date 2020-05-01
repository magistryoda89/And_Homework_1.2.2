package com.kolomiytsev.and_homework_122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvPhoto;
    private Button btnNext;
    private Button btnPrevious;
    static private int photoIndex = 0;
    static private int lastPhoto = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.main_activity_title));

        tvPhoto = findViewById(R.id.tv_photo);
        btnNext = findViewById(R.id.btn_next);
        btnPrevious = findViewById(R.id.btn_previous);

        if (photoIndex < 10) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            tvPhoto.setText(getString(R.string.tv_photo_text, i));
        } else if (lastPhoto > -1) {
            tvPhoto.setText(getString(R.string.tv_photo_text, lastPhoto));
        } else {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            tvPhoto.setText(getString(R.string.tv_photo_text, i));
            lastPhoto = i;
        }

        btnNext.setEnabled(photoIndex < 10);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoIndex++;
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoIndex--;
                MainActivity.this.finish();
            }
        });
    }
}

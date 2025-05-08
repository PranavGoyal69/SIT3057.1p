package com.example.lostfoundapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnViewItems = findViewById(R.id.btnViewItems);
        Button btnNewPost = findViewById(R.id.btnNewPost);

        btnViewItems.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ViewItemsActivity.class));
        });

        btnNewPost.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NewPostActivity.class));
        });
    }
}
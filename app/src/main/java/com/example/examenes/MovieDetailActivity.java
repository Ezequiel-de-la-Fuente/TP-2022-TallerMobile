package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.examenes.helper.Menu;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MovieDetailActivity.this, MoviesActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Menu.Init(this, R.id.toolbarMovieDetail);
    }
}
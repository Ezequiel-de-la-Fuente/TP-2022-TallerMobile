package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examenes.helper.Menu;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Menu.Init(this, R.id.toolbarMovieDetail);
    }
}
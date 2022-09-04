package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.examenes.helper.Menu;

public class MainWikiActivity extends AppCompatActivity {
    private LinearLayout goToMovie, goToCharacters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wiki);
        Menu.Init(this, R.id.toolbarMainWiki);
        goToMovie = findViewById(R.id.goToMovies);
        goToCharacters = findViewById(R.id.goToCharacters);

        goToMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainWikiActivity.this, MoviesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        goToCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainWikiActivity.this, CharactersActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
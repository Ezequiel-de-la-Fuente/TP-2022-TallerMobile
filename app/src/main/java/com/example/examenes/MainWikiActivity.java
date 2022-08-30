package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;

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
                //TODO: Hacer lista de peliculas
                Toast.makeText(MainWikiActivity.this, "Peliculas", Toast.LENGTH_SHORT).show();
            }
        });
        goToCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Hacer lista de personajes
                Toast.makeText(MainWikiActivity.this, "Personajes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
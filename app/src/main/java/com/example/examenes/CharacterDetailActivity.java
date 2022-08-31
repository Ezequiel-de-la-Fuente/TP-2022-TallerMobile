package com.example.examenes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examenes.helper.Menu;

public class CharacterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        Menu.Init(this, R.id.toolbarCharacterDetail);
    }
}
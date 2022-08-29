package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examenes.helper.Menu;

public class TermsAndConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        Menu.Init(this, R.id.toolbarTermsAndConditions);
    }
}
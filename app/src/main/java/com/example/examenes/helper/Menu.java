package com.example.examenes.helper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.examenes.R;

public class Menu {
    public static  void Init(AppCompatActivity activity, int id){
        Toolbar toolbar = activity.findViewById(id);
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Studio Ghibli");
    }
}

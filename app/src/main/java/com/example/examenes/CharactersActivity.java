package com.example.examenes;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenes.helper.Menu;
import com.example.examenes.list.character.Character;
import com.example.examenes.list.character.CharacterAdapter;

import java.util.ArrayList;
import java.util.List;

public class CharactersActivity extends AppCompatActivity {
    private RecyclerView rvCharactersList;
    private CharacterAdapter adapter;
    private int count=30;
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CharactersActivity.this, MainWikiActivity.class);
        startActivity(intent);
        finish();
    }
    //TODO: Cambiar el margen horizontal en pantallas mas grandes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        Menu.Init(this, R.id.toolbarCharacters);
        setupAdapter();
        Spinner dropdown = findViewById(R.id.spinnerCharacters);
        String[] items = new String[]{"5", "20", "50", "100", "250"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i);
                count = Integer.parseInt(item.toString());
                CharactersActivity.this.adapter.set(getPlaceHolders(count));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setupAdapter() {
        rvCharactersList = findViewById(R.id.rvCharacterList);
        int numberOfColumns = getNumberOfColumnsByScreenSize(getScreenWidth());
        if(rvCharactersList !=null){
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
            rvCharactersList.setLayoutManager((layoutManager));
            adapter = new CharacterAdapter(getPlaceHolders(count), new CharacterAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Character character) {
                    Intent intent = new Intent(CharactersActivity.this, CharacterDetailActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            rvCharactersList.setAdapter(adapter);
        }else{
            Log.d("LOG", "RV CHARACTER LIST IS NULL");
        }
    }

    private int getNumberOfColumnsByScreenSize(int screenWidth) {
        Log.d("LOG", Integer.toString(screenWidth));
        if(screenWidth < 500){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private List<Character> getPlaceHolders(int count) {
        ArrayList<Character> characters = new ArrayList<>();
        for(int i=0;i<count;i++){
            String id = Integer.toString(i);
            characters.add(new Character(id, "PlaceHolder_"+id, "", null));
        }
        return  characters;

    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.examenes.helper.Menu;
import com.example.examenes.list.movie.Movie;
import com.example.examenes.list.movie.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {
    private RecyclerView rvMovieList;
    private MovieAdapter adapter;
    private int count=30;
    //TODO: Cambiar el margen horizontal en pantallas mas grandes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        Menu.Init(this, R.id.toolbarMovies);
        setupAdapter();
        Spinner dropdown = findViewById(R.id.spinnerMovies);
        String[] items = new String[]{"5", "20", "50", "100", "250"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i);
                count = Integer.parseInt(item.toString());
                MoviesActivity.this.adapter.set(getPlaceHolders(count));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setupAdapter() {
        rvMovieList = findViewById(R.id.rvMovieList);
        int numberOfColumns = getNumberOfColumnsByScreenSize(getScreenWidth());
        if(rvMovieList !=null){
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
            rvMovieList.setLayoutManager((layoutManager));
            adapter = new MovieAdapter(getPlaceHolders(count), new MovieAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Movie movie) {
                    Intent intent = new Intent(MoviesActivity.this, MovieDetailActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            rvMovieList.setAdapter(adapter);
        }else{
            Log.d("LOG", "RV MOVIE LIST IS NULL");
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

    private List<Movie> getPlaceHolders(int count) {
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i=0;i<count;i++){
            String id = Integer.toString(i);
            movies.add(new Movie(id, "PlaceHolder_"+id, "", null));
        }
        return  movies;

    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
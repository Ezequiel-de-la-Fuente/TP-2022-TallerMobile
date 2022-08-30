package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.examenes.helper.Menu;
import com.example.examenes.list.Examen;
import com.example.examenes.list.ExamenAdapter;
import com.example.examenes.list.movie.Movie;
import com.example.examenes.list.movie.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {
    private RecyclerView rvMovieList;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        Menu.Init(this, R.id.toolbarMovies);
        setupAdapter();
    }

    private void setupAdapter() {
        rvMovieList = findViewById(R.id.rvMovieList);
        int numberOfColumns = getNumberOfColumnsByScreenSize(getScreenWidth());
        if(rvMovieList !=null){
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
            rvMovieList.setLayoutManager((layoutManager));
            adapter = new MovieAdapter(getPlaceHolders(), new MovieAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Movie movie) {
                    Toast.makeText(MoviesActivity.this, movie.getTitle(), Toast.LENGTH_SHORT).show();
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

    private List<Movie> getPlaceHolders() {
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i=0;i<30;i++){
            String id = Integer.toString(i);
            movies.add(new Movie(id, "PlaceHolder_"+id, "", null));
        }
        return  movies;

    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
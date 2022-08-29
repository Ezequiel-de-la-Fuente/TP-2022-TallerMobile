package com.example.examenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.examenes.helper.Menu;
import com.example.examenes.list.Examen;
import com.example.examenes.list.ExamenAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvExamenes;
    private ExamenAdapter adapter;
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_agregar:
                Intent intent = new Intent(MainActivity.this, AgregarExamenActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Menu.Init(this, R.id.toolbarMain);
        setupAdapter();
    }

    private void setupAdapter() {
        rvExamenes = findViewById(R.id.rvExamenesList);
        if(rvExamenes!=null){
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
            rvExamenes.setLayoutManager((layoutManager));
            adapter = new ExamenAdapter(getExamenes(), new ExamenAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Examen examen) {
                    Toast.makeText(MainActivity.this, examen.materia, Toast.LENGTH_SHORT).show();
                }
            });
            rvExamenes.setAdapter(adapter);
        }else{
            Log.d("LOG", "RV EXAMENES IS NULL");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private List<Examen> getExamenes() {
        return new ArrayList<Examen>() {{
            add(new Examen(1, "Ingenieria de Software 1", "2022-04-05"));
            add(new Examen(2, "Algoritmos y Estructuras de Datos", "2022-04-07"));
            add(new Examen(3, "Prueba de Software", "2022-04-08"));
            add(new Examen(4, "Matematica", "2022-04-10"));
        }};

    }
}
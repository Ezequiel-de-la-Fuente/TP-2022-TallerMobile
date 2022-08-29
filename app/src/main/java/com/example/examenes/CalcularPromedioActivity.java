package com.example.examenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenes.helper.Menu;

public class CalcularPromedioActivity extends AppCompatActivity {

    private TextView firstLabel;
    private  TextView secondLabel;
    private EditText editNota1;
    private  EditText editNota2;
    private Button btnPromedio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstLabel = findViewById(R.id.firstLabel);
        secondLabel = findViewById(R.id.secondLabel);
        editNota1 = findViewById(R.id.editNota1);
        editNota2 = findViewById(R.id.editNota2);
        btnPromedio = findViewById(R.id.btnPromedio);
        Menu.Init(this, R.id.toolbarMain);
        this.btnPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View x = CalcularPromedioActivity.this.getCurrentFocus();
                if (x != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(x.getWindowToken(), 0);
                }
                Toast.makeText(CalcularPromedioActivity.this, CalcularPromedioActivity.this.getPromedio(), Toast.LENGTH_LONG).show();
            }
        });
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            showWelcomePopup(bundle.getString("USER_NAME",""));
        }
    }

    private void showWelcomePopup(String userName) {
        Toast.makeText(CalcularPromedioActivity.this, "Bienvenido "+userName,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.editNota1.setText("10");
        this.editNota2.setText("10");
    }
    private String getPromedio(){
        double nota1 = Double.parseDouble(editNota1.getText().toString());
        double nota2 = Double.parseDouble(editNota2.getText().toString());
        double promedio = (nota1+nota2) / 2;
        return Double.toString(promedio);
    }
}
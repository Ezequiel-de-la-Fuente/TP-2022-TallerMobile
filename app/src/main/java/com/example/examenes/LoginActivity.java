package com.example.examenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examenes.helper.Menu;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName;
    private EditText etPassword;
    private CheckBox cbRememberUser;
    private Button btnCreateUser;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        cbRememberUser = findViewById(R.id.cbRememberUser);
        btnCreateUser = findViewById(R.id.btnCreateUser);
        btnLogin = findViewById(R.id.btnLogin);
        Menu.Init(this, R.id.toolbarLogin);
        this.btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, TermsAndConditionsActivity.class);
                startActivity(intent);
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isValid()){
                    Toast.makeText(LoginActivity.this, "Completar datos",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("USER_NAME", etUserName.getText().toString());
                startActivity(intent);
            }
        });
    }

    private boolean isValid() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        return !userName.isEmpty() && !password.isEmpty();
    }
}
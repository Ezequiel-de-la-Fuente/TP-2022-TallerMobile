package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenes.helper.MenuMain;
import com.example.examenes.user.User;
import com.example.examenes.user.UserManager;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName;
    private EditText etPassword;
    private CheckBox cbRememberUser;
    private TextView btnCreateUser;
    private Button btnLogin;
    private ImageButton ibChangePasswordVisibility;
    private boolean showPassword = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        cbRememberUser = findViewById(R.id.cbRememberUser);
        btnCreateUser = findViewById(R.id.btnCreateUser);
        btnLogin = findViewById(R.id.btnLogin);
        ibChangePasswordVisibility = findViewById(R.id.ibChangePasswordVisibility);
        MenuMain.Init(this, R.id.toolbarLogin);

        this.btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkUserExistence(etUserName.toString(), etPassword.toString())){
                    Intent intent = new Intent(LoginActivity.this, MainWikiActivity.class);
                    startActivity(intent);
                } else {
                    etUserName.setText("");
                    etPassword.setText("");
                    Toast.makeText(LoginActivity.this, "Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibChangePasswordVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(showPassword){
                    showPassword = false;
                    etPassword.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    ibChangePasswordVisibility.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                }else{
                    showPassword = true;
                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    ibChangePasswordVisibility.setImageResource(R.drawable.ic_baseline_visibility_24);
                }
            }
        });
    }

    private boolean checkUserExistence(String username, String password) {
        boolean exists = false;
        Log.i("Info", "Valor Informacion");
        if(isValid()){
            Log.i("Info", "Valor wirh");
            for(User user : getUsuarios()){
                Log.i("Info", user.toString());
                if(user.getUsername().equals(etUserName.getText().toString()) && user.getPassword().equals(etPassword.getText().toString()))
                    exists = true;
            }
        }
        return exists;
    }

    private boolean isValid() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        return !userName.isEmpty() && !password.isEmpty();
    }

    private List<User> getUsuarios() {
        try {
            return UserManager.getInstance(this).getUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
package com.example.examenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenes.helper.Menu;

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
                /*if(!isValid()){
                    Toast.makeText(LoginActivity.this, "Completar datos",Toast.LENGTH_SHORT).show();
                    return;
                }*/
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("USER_NAME", etUserName.getText().toString());
                startActivity(intent);
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

    private boolean isValid() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        return !userName.isEmpty() && !password.isEmpty();
    }
}
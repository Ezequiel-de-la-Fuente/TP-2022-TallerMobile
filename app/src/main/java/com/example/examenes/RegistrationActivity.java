package com.example.examenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenes.helper.Menu;

public class RegistrationActivity extends AppCompatActivity {
    private EditText etRegistrationUserName;
    private EditText etRegistrationPassword;
    private Button btnRegistrationCreateAccount;
    private ImageButton ibRegistrationChangePasswordVisibility;
    private boolean showPassword = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etRegistrationUserName = findViewById(R.id.etRegistrationUserName);
        etRegistrationPassword = findViewById(R.id.etRegistrationPassword);
        btnRegistrationCreateAccount = findViewById(R.id.btnRegistrationCreateAccount);
        ibRegistrationChangePasswordVisibility = findViewById(R.id.ibRegistrationChangePasswordVisibility);
        Menu.Init(this, R.id.toolbarRegistration);

        this.btnRegistrationCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(!isValid()){
                    Toast.makeText(LoginActivity.this, "Completar datos",Toast.LENGTH_SHORT).show();
                    return;
                }*/
                Intent intent = new Intent(RegistrationActivity.this, MainWikiActivity.class);
                intent.putExtra("USER_NAME", etRegistrationUserName.getText().toString());
                startActivity(intent);
            }
        });
        ibRegistrationChangePasswordVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(showPassword){
                    showPassword = false;
                    etRegistrationPassword.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    ibRegistrationChangePasswordVisibility.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                }else{
                    showPassword = true;
                    etRegistrationPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    ibRegistrationChangePasswordVisibility.setImageResource(R.drawable.ic_baseline_visibility_24);
                }
            }
        });
    }

    private boolean isValid() {
        String userName = etRegistrationUserName.getText().toString();
        String password = etRegistrationPassword.getText().toString();
        return !userName.isEmpty() && !password.isEmpty();
    }
}
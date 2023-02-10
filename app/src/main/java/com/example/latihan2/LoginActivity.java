package com.example.latihan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    //deskripsi
    private EditText textInputEmail;
    private EditText textInputUsername;
    private EditText textInputPassword;
    private Button btConfrim;
    private TextView tvemail;
    private TextView tvusername;
    private TextView tvpassword;
    private String email, userName, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWedget();

    }
    private void initWedget () {
        //deskripsi
        textInputEmail = findViewById(R.id.text_input_email);
        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
        btConfrim = findViewById(R.id.bt_Confrim);
        tvemail = findViewById(R.id.tv_email);
        tvusername = findViewById(R.id.tv_username);
        tvpassword = findViewById(R.id.tv_password);

    }
        //rumus pengerjaan
        private boolean validateEmail () {
            String emailInput = textInputEmail.getText().toString().trim();

            if (emailInput.isEmpty()) {
                textInputEmail.setError("Field can't be empety");
                return false;
            } else {
                textInputEmail.setError(null);
                return true;
            }

        }
        private boolean validateUsername () {
            String usernameinput = textInputEmail.getText().toString().trim();

            if (usernameinput.isEmpty()) {
                textInputUsername.setError("Field can't be empety");
                return false;
            } else if (usernameinput.length() > 15) {
                textInputUsername.setError("username too long");
                return false;
            } else {
                textInputUsername.setError(null);
                return true;
            }
        }

        private boolean validatePassword () {
            String passwordInput = textInputPassword.getText().toString().trim();

            if (passwordInput.isEmpty()) {
                textInputPassword.setError("Field can't be empety");
                return false;
            } else {
                textInputPassword.setError(null);
                return true;
            }

        }

        public void confirmInput (View v){
            if (!validateEmail() | !validateUsername() | !validatePassword()) {
                return;
            }

            String input = "Email: " + textInputEmail.getText().toString();
            input += "\n";
            input = "Username: " + textInputUsername.getText().toString();
            input += "\n";
            input = "Password: " + textInputPassword.getText().toString();

            Toast.makeText(this, input, Toast.LENGTH_LONG).show();


        }
    private void submitlogin (){
        email = textInputEmail.getText().toString();
        textInputEmail.setText(email);
        userName = textInputPassword.getText().toString();
        textInputPassword.setText(userName);

        password = textInputPassword.getText().toString();
        textInputPassword.setText(password);

        SharedPreferences inputan = this.getSharedPreferences("applikasi", Context.MODE_PRIVATE);
        SharedPreferences.Editor inputEditor = inputan.edit();
        inputEditor.putString("email",email);
        inputEditor.putString("username",userName);
        inputEditor.putString("password",password);
        inputEditor.apply();

        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);

    }
    

    }

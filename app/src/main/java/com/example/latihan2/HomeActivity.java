package com.example.latihan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView tvemail;
    private TextView tvusername;
    private  TextView tvpassword;
    private Button btlogout;
    private String email, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intiWidget();
        initAction();
        data();
    }
    private void intiWidget(){
        tvemail = findViewById(R.id.tv_email);
        tvusername = findViewById(R.id.tv_username);
        tvpassword = findViewById(R.id.tv_password);
        btlogout = findViewById(R.id.bt_logout);
    }
    private void initAction(){
        btlogout.setOnClickListener(view -> {
            kembali();

        });
    }
    private void data(){
        SharedPreferences inputan = this.getSharedPreferences("applikasi", Context.MODE_PRIVATE);
        email = inputan.getString("email","");
        username = inputan.getString("username","");
        password = inputan.getString("password","");

        //user = new UserModel(email,username,password);

        tvemail.setText(email);
        tvusername.setText(username);
        tvpassword.setText(password);
    }
    private void kembali(){
        SharedPreferences inputan = this.getSharedPreferences("applikasi", Context.MODE_PRIVATE);
        inputan.edit().clear().apply();
//        inputan.edit().remove("username").apply();

        Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
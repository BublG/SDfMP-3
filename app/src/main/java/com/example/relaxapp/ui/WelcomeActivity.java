package com.example.relaxapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.relaxapp.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button goToLoginButton = findViewById(R.id.go_to_login_button);
        goToLoginButton.setOnClickListener(this::goToLogin);
        TextView goToRegisterTextView = findViewById(R.id.go_to_register_text);
        goToRegisterTextView.setOnClickListener(this::goToRegister);
        getSupportActionBar().hide();
    }

    public void goToLogin(View view) {
        Intent toLoginActivity = new Intent(this, LoginActivity.class);
        startActivity(toLoginActivity);
    }

    public void goToRegister(View view) {
        Intent toRegisterActivity = new Intent(this, RegisterActivity.class);
        startActivity(toRegisterActivity);
    }
}
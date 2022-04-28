package com.example.relaxapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.relaxapp.R;
import com.example.relaxapp.db.AppDatabase;
import com.example.relaxapp.db.User;
import com.example.relaxapp.db.UserDao;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        userDao = AppDatabase.getInstance(getApplicationContext()).userDao();
        emailEditText = findViewById(R.id.login_email);
        passwordEditText = findViewById(R.id.login_password);
        TextView goToRegisterTextView = findViewById(R.id.go_to_register_from_login);
        goToRegisterTextView.setOnClickListener(this::goToRegister);
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this::loginUser);
    }

    public void goToRegister(View view) {
        Intent toRegisterActivity = new Intent(this, RegisterActivity.class);
        startActivity(toRegisterActivity);
    }

    public void loginUser(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        new Thread(() -> {
            User user = userDao.getByEmailAndPassword(email, password);
            if (user == null) {
                runOnUiThread(() -> Toast.makeText(getApplicationContext(),
                        "Invalid credentials", Toast.LENGTH_SHORT).show());
            } else {
                startActivity(new Intent(LoginActivity.this, MainActivity.class)
                        .putExtra("user", user));
            }
        }).start();
    }
}

package com.example.relaxapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.relaxapp.R;
import com.example.relaxapp.db.AppDatabase;
import com.example.relaxapp.db.User;
import com.example.relaxapp.db.UserDao;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        userDao = AppDatabase.getInstance(getApplicationContext()).userDao();
        emailEditText = findViewById(R.id.registration_email);
        usernameEditText = findViewById(R.id.registration_username);
        passwordEditText = findViewById(R.id.registration_password);
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this::registerUser);
    }

    public void registerUser(View view) {
        User user = new User();
        user.setEmail(emailEditText.getText().toString());
        user.setUsername(usernameEditText.getText().toString());
        user.setPassword(passwordEditText.getText().toString());
        new Thread(() -> {
            if (userHasEmptyField(user)) {
                runOnUiThread(() -> Toast.makeText(getApplicationContext(),
                        "Fill all fields", Toast.LENGTH_SHORT).show());
            } else {
                userDao.insert(user);
                runOnUiThread(() -> Toast.makeText(getApplicationContext(),
                        "User registered", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }

    private boolean userHasEmptyField(User user) {
        return (user.getEmail().isEmpty() || user.getUsername().isEmpty()
                || user.getPassword().isEmpty());
    }
}

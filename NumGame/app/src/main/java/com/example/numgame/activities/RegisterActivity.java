package com.example.numgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.numgame.R;
import com.example.numgame.src.UserManager;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    private EditText fieldUsername;
    private EditText fieldPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fieldUsername = findViewById(R.id.field_username);
        fieldPassword = findViewById(R.id.field_password);

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void register() {
        String username = fieldUsername.getText().toString();
        String password = fieldPassword.getText().toString();
        String gameLevel = "basic";

        new Thread(() -> {
            try {
                URL url = new URL("http://10.0.2.2:8000/users/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                String jsonInputString = String.format(
                        "{\"username\": \"%s\", \"password\": \"%s\", \"game_level\": \"%s\"}",
                        username, password, gameLevel);

                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int code = connection.getResponseCode();
                if (code == HttpURLConnection.HTTP_CREATED) {
                    Log.d("Register", "User created successfully.");
                    UserManager.getInstance().setUsername(username);
                    UserManager.getInstance().setPassword(password);
                    UserManager.getInstance().setGameLevel(gameLevel);
                    runOnUiThread(() -> {
                        Toast.makeText(RegisterActivity.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, Home.class);
                        startActivity(intent);
                        finish();
                    });
                } else {
                    Log.e("Register", "Error: " + code);
                    runOnUiThread(() -> {
                        Toast.makeText(RegisterActivity.this, "Failed to create user. Please try again.", Toast.LENGTH_SHORT).show();
                    });
                }

                connection.disconnect();
            } catch (Exception e) {
                Log.e("Register", "Error: " + e.getMessage());
                runOnUiThread(() -> {
                    Toast.makeText(RegisterActivity.this, "An error occurred. Please try again.", Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }

}
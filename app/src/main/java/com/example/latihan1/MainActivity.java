package com.example.latihan1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnregister, btnLogin;
    EditText edusername, edpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE);
        boolean sudahLogin = sharedPref.getBoolean("isLoggedIn", false);

        if (sudahLogin) {
            startActivity(new Intent(MainActivity.this, list_lagu.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        edusername = findViewById(R.id.edusername);
        edpassword = findViewById(R.id.edpassword);
        btnLogin = findViewById(R.id.btnlogin);
        btnregister = findViewById(R.id.btnregister);

        btnLogin.setOnClickListener(v -> {
            String username = edusername.getText().toString();
            String password = edpassword.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username_key", username);
                editor.putBoolean("isLoggedIn", true);
                editor.apply();

                Toast.makeText(MainActivity.this, "Selamat Datang, " + username, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, list_lagu.class);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(MainActivity.this, "Username dan Password harus diisi!", Toast.LENGTH_SHORT).show();
            }
        });

        btnregister.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, Register.class))
        );
    }
}
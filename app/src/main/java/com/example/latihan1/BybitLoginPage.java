package com.example.latihan1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.latihan1.databinding.ActivityBybitLoginPageBinding;

public class BybitLoginPage extends AppCompatActivity {

    private ActivityBybitLoginPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBybitLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.edEmail.getText().toString();
                String password = binding.edPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(BybitLoginPage.this, "Isi email dan password!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BybitLoginPage.this, "Mencoba Masuk...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.imgBack.setOnClickListener(v -> finish());
    }
}
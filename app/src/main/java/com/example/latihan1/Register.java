package com.example.latihan1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText username,email,address,phone,password,confirm;
    Button btnregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.edusername);
        email = findViewById(R.id.edEmail);
        address = findViewById(R.id.edaddres);
        phone = findViewById(R.id.edphonenumber);
        password = findViewById(R.id.edpassword);
        confirm = findViewById(R.id.edconfirmpassword);

        btnregist = findViewById(R.id.btnregist);

        btnregist.setOnClickListener(v -> {

            Intent intent = new Intent(Register.this, ConfirmRegister.class);

            intent.putExtra("username", username.getText().toString());
            intent.putExtra("email", email.getText().toString());
            intent.putExtra("address", address.getText().toString());
            intent.putExtra("phone", phone.getText().toString());
            intent.putExtra("password", password.getText().toString());
            intent.putExtra("confirm", confirm.getText().toString());

            startActivity(intent);

        });
    }
}
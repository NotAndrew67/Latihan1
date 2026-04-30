package com.example.latihan1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmRegister extends AppCompatActivity {

    TextView username,email,address,phone,password,confirm;
    Button btnback, btnconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_register);

        username = findViewById(R.id.txtshowusername);
        email = findViewById(R.id.txtshowemail);
        address = findViewById(R.id.txtshowaddres);
        phone = findViewById(R.id.txtshowphonenumber);
        password = findViewById(R.id.txtshowpassword);
        confirm = findViewById(R.id.txtshowconfirm);

        btnback = findViewById(R.id.btnback);
        btnconfirm = findViewById(R.id.btnconfirm);

        Intent intent = getIntent();

        String user = intent.getStringExtra("username");
        String mail = intent.getStringExtra("email");
        String addr = intent.getStringExtra("address");
        String ph = intent.getStringExtra("phone");
        String pass = intent.getStringExtra("password");
        String conf = intent.getStringExtra("confirm");

        username.setText("Username : " + user);
        email.setText("Email : " + mail);
        address.setText("Address : " + addr);
        phone.setText("Phone Number : " + ph);
        password.setText("Password : " + pass);
        confirm.setText("Confirm Password : " + conf);

        btnback.setOnClickListener(v -> {
            finish();
        });

        btnconfirm.setOnClickListener(v -> {
            Intent i = new Intent(ConfirmRegister.this, MainActivity.class);
            startActivity(i);
        });

    }
}
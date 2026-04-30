package com.example.latihan1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KalkulatorAritmatika extends AppCompatActivity {

    EditText edangka1;
    EditText edangka2;
    Button btntambah;
    Button btnkurang;
    Button btnkali;
    Button btnbagi;
    TextView txthasil;

    TextView Username;

    Button btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_aritmatika);

        Username = (TextView)findViewById(R.id.txtWelcome);

        String username = getIntent().getStringExtra("namauser");

        Username.setText("Welcome : "+username);

        edangka1 = (EditText) findViewById(R.id.edangka1);
        edangka2 = (EditText) findViewById(R.id.edangka2);
        btntambah = (Button) findViewById(R.id.btntambah);
        btnkurang = (Button) findViewById(R.id.btnkurang);
        btnkali = (Button) findViewById(R.id.btnkali);
        btnbagi = (Button) findViewById(R.id.btnbagi);
        btnclear = (Button) findViewById(R.id.btnclear);
        txthasil = (TextView) findViewById(R.id.txthasil);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka1 = Integer.parseInt(edangka1.getText().toString());
                int angka2 = Integer.parseInt(edangka2.getText().toString());
                int hasil = angka1 + angka2;
                txthasil.setText("Hasil : " + hasil);
            }
        });

        btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka1 = Integer.parseInt(edangka1.getText().toString());
                int angka2 = Integer.parseInt(edangka2.getText().toString());
                int hasil = angka1 - angka2;
                txthasil.setText("Hasil : " + hasil);
            }
        });

        btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka1 = Integer.parseInt(edangka1.getText().toString());
                int angka2 = Integer.parseInt(edangka2.getText().toString());
                int hasil = angka1 * angka2;
                txthasil.setText("Hasil : " + hasil);
            }
        });

        btnbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double angka1 = Integer.parseInt(edangka1.getText().toString());
                double angka2 = Integer.parseInt(edangka2.getText().toString());
                double hasil = angka1 / angka2;
                txthasil.setText("Hasil : " + hasil);
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edangka1.setText("");
                edangka2.setText("");
                txthasil.setText("Hasil : ");
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
    }
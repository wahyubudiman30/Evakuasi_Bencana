package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    private Button BtnUbahAkun, BtnTambahAdmin;
    private TextView BtnUbahProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        BtnUbahAkun = findViewById(R.id.BtnUbahAkun);
        BtnTambahAdmin = findViewById(R.id.BtnTambahAdmin);
        BtnUbahProfil = findViewById(R.id.BtnUbahProfil);

        BtnUbahAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilActivity.this,UbahpassActivity.class);
                startActivity(intent);
            }
        });

        BtnTambahAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilActivity.this,TambahakunActivity.class);
                startActivity(intent);
            }
        });

        BtnUbahProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilActivity.this,UbahprofilActivity.class);
                startActivity(intent);
            }
        });
    }
}
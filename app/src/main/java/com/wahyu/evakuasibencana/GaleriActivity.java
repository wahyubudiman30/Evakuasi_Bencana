package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GaleriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);
    }

    public void TambahGaleri(View view) {
        Intent intent = new Intent(GaleriActivity.this,TambahgaleriActivity.class);
        startActivity(intent);
    }
}
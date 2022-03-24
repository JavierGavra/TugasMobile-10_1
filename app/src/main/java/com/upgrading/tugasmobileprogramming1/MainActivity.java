package com.upgrading.tugasmobileprogramming1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_berat, btn_panjang, btn_temperatur, btn_waktu, btn_kecepatan, btn_luas, btn_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_berat = findViewById(R.id.btn_berat_main);
        btn_panjang = findViewById(R.id.btn_panjang_main);
        btn_temperatur = findViewById(R.id.btn_temperatur_main);
        btn_waktu = findViewById(R.id.btn_waktu_main);
        btn_kecepatan = findViewById(R.id.btn_kecepatan_main);
        btn_luas = findViewById(R.id.btn_luas_main);
        btn_data = findViewById(R.id.btn_data_main);

        // Tombol Berat
        btn_berat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toBeratPage = new Intent(getApplicationContext(), BeratActivity.class);
                startActivity(toBeratPage);
            }
        });

        // Tombol Panjang
        btn_panjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPanjangPage = new Intent(getApplicationContext(), PanjangActivity.class);
                startActivity(toPanjangPage);
            }
        });

        // Tombol Tempratur
        btn_temperatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTemperaturPage = new Intent(getApplicationContext(), TemperaturActivity.class);
                startActivity(toTemperaturPage);
            }
        });

        // Tombol Waktu
        btn_waktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toWaktuPage = new Intent(getApplicationContext(), WaktuActivity.class);
                startActivity(toWaktuPage);
            }
        });

        // Tombol Kecepatan
        btn_kecepatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toKecepatanPage = new Intent(getApplicationContext(), KecepatanActivity.class);
                startActivity(toKecepatanPage);
            }
        });

        // Tombol Luas
        btn_luas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLuasPage = new Intent(getApplicationContext(), LuasActivity.class);
                startActivity(toLuasPage);
            }
        });

        // Tombol Data
        btn_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDataPage = new Intent(getApplicationContext(), DataActivity.class);
                startActivity(toDataPage);
            }
        });


    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Yakin Ingin Keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }
}
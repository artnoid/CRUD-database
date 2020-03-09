package com.example.praktikum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.praktikum.database.AppDatabase;
import com.example.praktikum.database.DataDiri;


public class MainActivity extends AppCompatActivity {

    private EditText etNama, etAlamat, etJenisKelamin;
    private Button btnInsert, btnRead, btnDelete, btnUpdate;

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.initDB(getApplicationContext()); //menambahkan database

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etJenisKelamin = findViewById(R.id.etJenisKelamin);

        btnInsert = findViewById(R.id.btnInsert);
        btnRead = findViewById(R.id.btnRead);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent read = new Intent(getApplicationContext(), DataRead.class);
                startActivity(read);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
    }

    private void updateData() {
    }

    private void deleteData() {
    }

    private void insertData(){
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        char jenisKelamin = etJenisKelamin.getText().toString().charAt(0);

        DataDiri item = new DataDiri();
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJenisKelamin(jenisKelamin);

        //setelah itu kirim ke database
        appDatabase.dao().insertData(item);

        etNama.setText("");
        etAlamat.setText("");
        etJenisKelamin.setText("");
    }
}

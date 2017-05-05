package com.example.rahmatridham.aplikasifjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rahmatridham.aplikasifjb.Model.Produk;

public class FormProduk extends AppCompatActivity {
    EditText idProduk, namaProduk, harga, stok, deskripsi, kontak;
    Button oke, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_produk);

        idProduk = (EditText) findViewById(R.id.editTextidproduk);
        namaProduk = (EditText) findViewById(R.id.editTextNamaProduk);
        harga = (EditText) findViewById(R.id.editTextHarga);
        stok = (EditText) findViewById(R.id.editTextStok);
        deskripsi = (EditText) findViewById(R.id.editTextDeskripsi);
        kontak = (EditText) findViewById(R.id.editTextContact);

        cancel = (Button) findViewById(R.id.buttonCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FormProduk.this, Home.class));
            }
        });

        oke = (Button) findViewById(R.id.buttonOk);
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home.produkArrayList.add(new Produk(idProduk.getText().toString(), namaProduk.getText().toString(), harga.getText().toString(), deskripsi.getText().toString(), kontak.getText().toString(), Integer.valueOf(stok.getText().toString())));
                Home.getDaftarNamaProduk();
                Home.adapter.notifyDataSetChanged();
                startActivity(new Intent(FormProduk.this,Home.class));
            }
        });
    }

    
}

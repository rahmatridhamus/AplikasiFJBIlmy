package com.example.rahmatridham.aplikasifjb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rahmatridham.aplikasifjb.Model.Produk;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    public static ArrayList<Produk> produkArrayList;
    ListView listView;
    static ArrayAdapter<String> adapter;
    String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, FormProduk.class);
                startActivity(intent);
            }
        });

        addProduct();
        strings = getDaftarNamaProduk();
        listView = (ListView) findViewById(R.id.listViewProduk);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produk model = produkArrayList.get(i);
                String s = model.getDesc();
                Toast.makeText(Home.this, s, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Home.this, DetailProductActivity.class);
                intent.putExtra("namaProduk", model.getNamaProduk());
                intent.putExtra("deskripsiProduk", model.getDesc());
                intent.putExtra("contactProduk", model.getContact());
                startActivity(intent);
            }
        });
        getDaftarNamaProduk();
        adapter.notifyDataSetChanged();
    }

    public void addProduct() {
        produkArrayList = new ArrayList<>();
        produkArrayList.add(new Produk("1", "Vit Botol", "3000", "Vit enak menyegarkan", "0822123123", 2));
        produkArrayList.add(new Produk("2", "Bengbeng", "2000", "Bengbeng enak menyegarkan", "0822123123", 2));
        produkArrayList.add(new Produk("3", "Tanggo", "3000", "Vit enak menyegarkan", "0822123123", 2));
        produkArrayList.add(new Produk("4", "Monitor", "3000", "Vit enak menyegarkan", "0822123123", 2));
        produkArrayList.add(new Produk("5", "Laptop", "3000", "Vit enak menyegarkan", "0822123123", 2));
    }

    public static String[] getDaftarNamaProduk() {
        String[] resultStrings = new String[produkArrayList.size()];
        for (int i = 0; i < produkArrayList.size(); i++) {
            resultStrings[i] = produkArrayList.get(i).getNamaProduk();
        }
        return resultStrings;
    }


}

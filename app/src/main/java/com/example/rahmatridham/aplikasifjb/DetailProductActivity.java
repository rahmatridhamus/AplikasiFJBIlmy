package com.example.rahmatridham.aplikasifjb;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailProductActivity extends AppCompatActivity {
    TextView namaProduk, deskripsiProduk;
    ImageView imageProduk, imageTelfon;
    String noTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        namaProduk = (TextView) findViewById(R.id.textViewNamaProduk);
        deskripsiProduk = (TextView) findViewById(R.id.textViewDeskripsi);
        imageProduk = (ImageView) findViewById(R.id.imageViewFoto);
        imageTelfon = (ImageView) findViewById(R.id.imageViewtelfon);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            namaProduk.setText(bundle.getString("namaProduk"));
            deskripsiProduk.setText(bundle.getString("deskripsiProduk"));
            noTelp = bundle.getString("contactProduk");
        }

        imageTelfon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:" + noTelp));
                if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent1);
            }
        });

    }
}

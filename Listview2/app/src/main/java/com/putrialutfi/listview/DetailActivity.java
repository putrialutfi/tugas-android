package com.putrialutfi.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    TextView tvNamaBuah;
    ImageView ivGambarBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String namabuah = getIntent().getStringExtra(Konstanta.DATANAMA);
        int gambarbuah = getIntent().getIntExtra(Konstanta.DATAGAMBAR, 0);

        Log.d(TAG, "Nama: " + namabuah);
        Log.d(TAG, "Gambar: " + gambarbuah);

        tvNamaBuah = findViewById(R.id.tv_detail_nama);
        ivGambarBuah = findViewById(R.id.iv_detail_gambar);

        tvNamaBuah.setText(namabuah);
        ivGambarBuah.setImageResource(gambarbuah);
    }
}

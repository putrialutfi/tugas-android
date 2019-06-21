package com.putrialutfi.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] namaBuah = {
            "Alpukat",
            "Apel",
            "Ceri",
            "Durian",
            "Jambu Air",
            "Manggis",
            "Strawberry"
    };

    int[] gambarBuah = {
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry
    };

    int[] suaraBuah = {
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
            R.raw.jambuair,
            R.raw.manggis,
            R.raw.strawberry
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list_view);

//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, namaBuah);
        CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, namaBuah, gambarBuah);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MediaPlayer.create(MainActivity.this, suaraBuah[i]).start();

                Intent move = new Intent(MainActivity.this, DetailActivity.class);
                move.putExtra(Konstanta.DATANAMA, namaBuah[i]);
                move.putExtra(Konstanta.DATAGAMBAR, gambarBuah[i]);
                startActivity(move);
            }
        });
    }
}

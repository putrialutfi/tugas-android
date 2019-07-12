package com.putrialutfi.offlinedatabase;

import android.content.Intent;
import android.os.Bundle;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<CatatanModel> dataCatatan = new ArrayList<>();
    RecyclerView recyclerView;
    RealmHelper realmHelper;
    FloatingSearchView floatingSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });

        realmHelper = new RealmHelper(MainActivity.this);

//        CatatanModel catatanModel = new CatatanModel();
//        catatanModel.setId("1");
//        catatanModel.setJudul("Hutang ke B");
//        catatanModel.setJumlahHutang("30000");
//        catatanModel.setTanggal("28-06-2012");
//
//        for (int i = 0; i < 20; i++) {
//            dataCatatan.add(catatanModel);
//        }

        dataCatatan = realmHelper.showData();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new CatatanAdapter(MainActivity.this, dataCatatan));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, 1));

        floatingSearchView = findViewById(R.id.floating_search_view);
        floatingSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
//                Toast.makeText(MainActivity.this, ""+newQuery, Toast.LENGTH_SHORT).show();
                List<CatatanModel> filter = filterData(dataCatatan, newQuery);
                recyclerView.setAdapter(new CatatanAdapter(MainActivity.this, filter));
            }
        });
    }

    private List<CatatanModel> filterData(List<CatatanModel> dataCatatan, String newQuery) {
        String lowercasequery = newQuery.toLowerCase();
        List<CatatanModel> filterData = new ArrayList<>();
        for (int i = 0; i < dataCatatan.size(); i++) {
            String text = dataCatatan.get(i).getJudul().toLowerCase();
            if (text.contains(lowercasequery)) {
                filterData.add(dataCatatan.get(i));
            }
        }
        return filterData;
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataCatatan = realmHelper.showData();
        recyclerView.setAdapter(new CatatanAdapter(MainActivity.this, dataCatatan));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

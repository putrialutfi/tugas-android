package com.putrialutfi.onlinedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.putrialutfi.onlinedatabase.model.ResponseMovie;
import com.putrialutfi.onlinedatabase.model.ResultsItem;
import com.putrialutfi.onlinedatabase.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<ResultsItem> dataMovie = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

//        MovieModel movie1 = new MovieModel();
//        movie1.setJudulFilm("Avenger: Age of Ultron");
//        movie1.setPosterFilm("https://image.tmdb.org/t/p/w300_and_h450_bestv2/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg");
//
//        for (int i = 0; i < 20; i++) {
//            dataMovie.add(movie1);
//        }

        getDataOnline();

        recyclerView.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
    }

    private void getDataOnline() {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Waiting for Movies ...");
        progressDialog.show();

        Call<ResponseMovie> request = RetrofitConfig.getApiService().ambilDataMovie("53936e70d5c58f0c53345130ff071fb5");
        request.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                progressDialog.dismiss();
                if(response.isSuccessful()){
                    dataMovie = response.body().getResults();
                    recyclerView.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
                } else {
                    Toast.makeText(MainActivity.this, "Request Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Reques Failure : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}

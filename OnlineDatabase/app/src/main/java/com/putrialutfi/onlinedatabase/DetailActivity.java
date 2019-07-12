package com.putrialutfi.onlinedatabase;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.putrialutfi.onlinedatabase.model.ResultsItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    ResultsItem dataMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getBundleExtra(MovieAdapter.DATA_EKSTRA);
        dataMovie = Parcels.unwrap(bundle.getParcelable(MovieAdapter.DATA_MOVIE));

        ImageView ivBackdrop = findViewById(R.id.iv_backdrop);
        TextView tvMovieDesc = findViewById(R.id.tv_detail_desc);

        Glide.with(DetailActivity.this)
                .load("https://image.tmdb.org/t/p/w500"+dataMovie.getBackdropPath())
                .into(ivBackdrop);
        tvMovieDesc.setText(dataMovie.getOverview());

        getSupportActionBar().setTitle(dataMovie.getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}

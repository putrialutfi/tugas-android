package com.example.layouting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button mBtnLinear, mBtnRelative, mBtnFrame, mBtnConstraint, mBtnScroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mBtnLinear = findViewById(R.id.btn_linear);
        mBtnRelative = findViewById(R.id.btn_relative);
        mBtnFrame = findViewById(R.id.btn_frame);
        mBtnConstraint = findViewById(R.id.btn_constraint);
        mBtnScroll = findViewById(R.id.btn_scroll);

        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MenuActivity.this, "Toast Linear Layout", Toast.LENGTH_SHORT).show();
                Intent move = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(move);
            }
        });

        mBtnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder message = new AlertDialog.Builder(MenuActivity.this);
                message.setTitle("Alert Dialog");
                message.setMessage("Isi Alert Dialog");
                message.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MenuActivity.this, "Anda Memilih OK", Toast.LENGTH_SHORT).show();
                        Intent move = new Intent(MenuActivity.this, RelativeActivity.class);
                        startActivity(move);
                    }
                });
                message.setNegativeButton("NO", null);
                message.show();
            }
        });

        mBtnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(MenuActivity.this, FrameActivity.class);
                startActivity(move);
            }
        });

        mBtnConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(MenuActivity.this, ConstraintActivity.class);
                startActivity(move);
            }
        });

        mBtnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(MenuActivity.this, ScrollActivity.class);
                startActivity(move);
            }
        });
    }
}

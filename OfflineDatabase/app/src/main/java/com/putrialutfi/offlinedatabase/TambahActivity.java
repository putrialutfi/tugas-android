package com.putrialutfi.offlinedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TambahActivity extends AppCompatActivity {

    EditText edJudul, edJumlah, edTanggal;
    Button btnSimpan;

    RealmHelper realmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edJudul = findViewById(R.id.ed_judul);
        edJumlah = findViewById(R.id.ed_jumlah);
        edTanggal = findViewById(R.id.ed_tanggal);
        btnSimpan = findViewById(R.id.btn_delete);

        realmHelper = new RealmHelper(TambahActivity.this);

        edTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int nowYear = calendar.get(Calendar.YEAR);
                int nowMonth = calendar.get(Calendar.MONTH);
                int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dateDialog = new DatePickerDialog(TambahActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month, dayOfMonth);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                        edTanggal.setText(dateFormat.format(cal.getTime()));
                    }
                }, nowYear, nowMonth, nowDay);
                dateDialog.show();
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatatanModel catatanModel = new CatatanModel();
                catatanModel.setId((int) realmHelper.getNextId());
                catatanModel.setJudul(edJudul.getText().toString());
                catatanModel.setJumlahHutang(edJumlah.getText().toString());
                catatanModel.setTanggal(edTanggal.getText().toString());

                realmHelper.insertData(catatanModel);
                finish();
            }
        });
    }
}

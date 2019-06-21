package com.putrialutfi.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    private Context context;
    private String[] namabuah;
    private int[] gambarbuah;

    public CustomListAdapter(Context context1, String[] namabuah, int[] gambarbuah) {
        super(context1, R.layout.item_buah, namabuah);
        this.context = context1;
        this.namabuah = namabuah;
        this.gambarbuah = gambarbuah;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater;
        View view = LayoutInflater.from(context).inflate(R.layout.item_buah, parent, false);
        TextView tvNamaBuah = view.findViewById(R.id.tv_detail_nama);
        ImageView ivGambarBuah = view.findViewById(R.id.iv_detail_gambar);

        tvNamaBuah.setText(namabuah[position]);
        ivGambarBuah.setImageResource(gambarbuah[position]);

        return view;
    }
}

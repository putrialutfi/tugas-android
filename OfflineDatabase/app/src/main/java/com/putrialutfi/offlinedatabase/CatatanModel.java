package com.putrialutfi.offlinedatabase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CatatanModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String judul;
    private String jumlahHutang;
    private String tanggal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJumlahHutang() {
        return jumlahHutang;
    }

    public void setJumlahHutang(String jumlahHutang) {
        this.jumlahHutang = jumlahHutang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}

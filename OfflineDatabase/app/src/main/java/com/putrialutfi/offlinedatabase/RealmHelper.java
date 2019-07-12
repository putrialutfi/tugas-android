package com.putrialutfi.offlinedatabase;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class RealmHelper {
    private Context context;
    private Realm realm;

    public RealmHelper(Context context) {
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    //nextid
    public long getNextId(){
        if (realm.where(CatatanModel.class).count() != 0){
            long id = realm.where(CatatanModel.class).max("id").longValue();
            return id+1;
        } else {
            return 1;
        }
    }

    //insert
    public void insertData(CatatanModel catatanModel){
        realm.beginTransaction();
        realm.copyToRealm(catatanModel);
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
        realm.close();
    }

    //read
    public List<CatatanModel> showData(){
        realm.beginTransaction();
        RealmResults<CatatanModel> dataHasil = realm.where(CatatanModel.class).findAll();
        List<CatatanModel> dataList = new ArrayList<>();
        dataList.addAll(realm.copyFromRealm(dataHasil));
        realm.commitTransaction();
        return dataList;
    }

    //show data
    public CatatanModel showOneData(Integer id){
        CatatanModel data = realm.where(CatatanModel.class).equalTo("id", id).findFirst();
        return data;
    }

    //update
    public void updateData(CatatanModel catatanModel){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(catatanModel);
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context, "Data Berhasil Diperbarui", Toast.LENGTH_SHORT).show();

            }
        });
        realm.close();
    }

    //delete
    public void deleteData(Integer id){
        realm.beginTransaction();
        CatatanModel catatanModel = realm.where(CatatanModel.class).equalTo("id", id).findFirst();
        catatanModel.deleteFromRealm();
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.pmob.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.pmob.myapplication.database.DatabaseClient;
import com.pmob.myapplication.database.dao.DatabaseDao;
import com.pmob.myapplication.model.ModelDatabase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class DonasiViewModel extends AndroidViewModel {

    DatabaseDao databaseDao;

    public DonasiViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
    }

    public void addDonasi(final String note, final int price) {
        Completable.fromAction(() -> {
            ModelDatabase modelDatabase = new ModelDatabase();
            modelDatabase.keterangan = note;
            modelDatabase.jmlUang = price;
            databaseDao.insertDonasi(modelDatabase);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}

package com.pmob.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pmob.myapplication.database.DatabaseClient;
import com.pmob.myapplication.database.dao.DatabaseDao;
import com.pmob.myapplication.model.ModelDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;




public class HistoryViewModel extends AndroidViewModel {

    LiveData<List<ModelDatabase>> modelDatabase;
    DatabaseDao databaseDao;

    public HistoryViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
        modelDatabase = databaseDao.getAllData();
    }

    public LiveData<List<ModelDatabase>> getDataList() {
        return modelDatabase;
    }

    public void deleteDataById(final int uid) {
        Completable.fromAction(() -> databaseDao.deleteSingleData(uid))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
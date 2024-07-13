package com.pmob.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pmob.myapplication.database.DatabaseClient;
import com.pmob.myapplication.database.dao.DatabaseDao;



public class MainViewModel extends AndroidViewModel {

    DatabaseDao databaseDao;
    LiveData<Integer> integerLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
        integerLiveData = databaseDao.getTotalDonasi();
    }

    public LiveData<Integer> getTotalDonasi() {
        return integerLiveData;
    }

}

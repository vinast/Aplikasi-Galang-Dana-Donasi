package com.pmob.myapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pmob.myapplication.model.ModelDatabase;
import com.pmob.myapplication.database.dao.DatabaseDao;


@Database(entities = {ModelDatabase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}

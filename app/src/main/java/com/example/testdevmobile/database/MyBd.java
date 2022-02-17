package com.example.testdevmobile.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {
        Student.class
}, version = 1)
public abstract class MyBd extends RoomDatabase {

    public abstract StudentDao studentDao();
}

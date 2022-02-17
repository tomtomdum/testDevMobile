package com.example.testdevmobile.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getall();

    @Query("SELECT * FROM student WHERE id = :id")
    Student get(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Student... students);

    @Delete
    void delete(Student... students);
}

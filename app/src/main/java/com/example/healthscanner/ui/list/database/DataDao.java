package com.example.healthscanner.ui.list.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM user_health")
    LiveData<List<DataEntity>> getAllBlogPosts();

    @Query("SELECT * FROM user_health WHERE hid = :id LIMIT 1")
    LiveData<List<DataEntity>> findDataEntityById(long id);

    @Query("SELECT * FROM user_health WHERE 'data-name' LIKE :title LIMIT 1")
    LiveData<List<DataEntity>> findDataEntityByTitle(String title);

    @Query("SELECT COUNT(*) FROM user_health")
    int rowCount();

    @Insert
    void insertData(DataEntity... user_health);

    @Update
    void updateData(DataEntity... user_health);

    @Delete
    void deleteData(DataEntity... user_health);
}

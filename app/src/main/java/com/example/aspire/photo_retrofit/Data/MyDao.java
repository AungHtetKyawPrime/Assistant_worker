package com.example.aspire.photo_retrofit.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {
    @Query("Select * From Event")
    LiveData<List<Model>> getAllEvent();

    @Insert
    void insertEvent(Model model);
    @Delete
    void deleteEvent(Model model);
    @Query("Update Event Set content=:content,date=:date where id=:id")
    void updateEvent(String content, String date, int id);
}

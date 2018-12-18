package com.example.aspire.photo_retrofit.memory_Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aspire.photo_retrofit.memory_Data.Memory_Model;

import java.util.List;

@Dao
public interface Memory_Dao {
    @Query("Select * From Memory")
    LiveData<List<Memory_Model>> getAllMemory();

    @Insert
    void insertMemory(Memory_Model model);
    @Delete
    void deleteMemory(Memory_Model model);
    @Query("Update Memory Set content=:content where id=:id")
    void updateMemory(String content, int id);
}

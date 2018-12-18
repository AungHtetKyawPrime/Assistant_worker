package com.example.aspire.photo_retrofit.Money_Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface Money_Dao {
    @Query("Select * From Money")
    LiveData<List<Money_Model>> getAllMoney();

    @Insert
    void insertMoney(Money_Model model);
    @Delete
    void deleteMoney(Money_Model model);
    @Query("Update Money Set content=:content ,date=:date,income=:income,outcome=:outcome where id=:id")
    void updateMoney(String content,String date,String income,String outcome, int id);
}

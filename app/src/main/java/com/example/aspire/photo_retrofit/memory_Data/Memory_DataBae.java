package com.example.aspire.photo_retrofit.memory_Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.aspire.photo_retrofit.memory_Data.Memory_Model;


@Database(entities = {Memory_Model.class},version = 1,exportSchema = false)
public abstract class Memory_DataBae extends RoomDatabase{

    private static Memory_DataBae memoryDataBae;
    Context context;
    public static Memory_DataBae getInstance(Context context){

        if(memoryDataBae == null){
            memoryDataBae = Room.databaseBuilder(context.getApplicationContext(), Memory_DataBae.class, "Memory-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return memoryDataBae;
    }
    public abstract Memory_Dao data();
}

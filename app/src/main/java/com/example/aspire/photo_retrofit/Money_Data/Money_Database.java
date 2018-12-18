package com.example.aspire.photo_retrofit.Money_Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Money_Model.class},version = 1,exportSchema = false)
public abstract class Money_Database extends RoomDatabase{

    private static Money_Database memoryDataBae;
    Context context;
    public static Money_Database getInstance(Context context){

        if(memoryDataBae == null){
            memoryDataBae = Room.databaseBuilder(context.getApplicationContext(), Money_Database.class, "Money-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return memoryDataBae;
    }
    public abstract Money_Dao data();
}

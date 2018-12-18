package com.example.aspire.photo_retrofit.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Model.class},version = 1,exportSchema = false)
public abstract class MyDataBae extends RoomDatabase{

    private static MyDataBae myDataBae;
    Context context;
    public static MyDataBae getInstance(Context context){

        if(myDataBae == null){
            myDataBae = Room.databaseBuilder(context.getApplicationContext(), MyDataBae.class, "Event-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return myDataBae;
    }
    public abstract MyDao data();
}

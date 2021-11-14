package com.example.healthscanner.ui.list.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataEntity.class}, version = 1, exportSchema = false)
public abstract class Adddatabase extends RoomDatabase {
    private static Adddatabase INSTANCE;

    public static Adddatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    Adddatabase.class,
                    "UserHealthdata")
                    .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract DataDao dataDao();
}

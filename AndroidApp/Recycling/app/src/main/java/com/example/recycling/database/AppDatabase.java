/*
* define the local database
* in the code, we can create an instance of the class to create a new database
*
* */

package com.example.recycling.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Data.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDao dataDao();
}

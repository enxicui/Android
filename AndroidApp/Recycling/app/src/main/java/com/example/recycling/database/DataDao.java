/*
* This is the data access object (DAO) of the table
* It defines the common used method to read the data from the table
* */

package com.example.recycling.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDao {
    /*
    * The main method we used to read the data from the table
    * The user need to specify the area
    * */
    @Query("SELECT * FROM data where area LIKE :area")
    List<Data> findByMonthAndArea(String area);

    /*
    * if there exists an entry in the table
    * we will replace the old entry with the new one
    * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(Data... data);

    /*
    * This method use required by the room library
    * */
    @Update
    void updateData(Data... data);
}

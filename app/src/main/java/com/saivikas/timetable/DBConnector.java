package com.saivikas.timetable;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by coderfreak on 1/8/2016.
 */
public class DBConnector {
    DBHelper myDbHelper;
    Activity activity;
    List<String> myList;
    Cursor c;

    public DBConnector(Activity activity) {
        this.activity = activity;
    }
    public void connectToDatabase() {
        myDbHelper = new DBHelper(activity);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
    }
    public List populateList(String ID) {
        //creating an array list of items
        myList = new ArrayList<String>();

        //populating the list
        c = myDbHelper.rawquery("select * from subjects where _id=" + ID, null);
        c.moveToFirst();
        for(int i=1;i<9;i++) {
            myList.add(i+". "+c.getString(i+1));
        }
        return myList;
    }
}

package com.saivikas.timetable;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by coderfreak on 1/8/2016.
 */


public class Teacher extends Fragment {

    DBHelper myDbHelper;
    ListView lv;
    Cursor c;

    DBConnector dbConnect;

    public static final String SATURDAY_ID = "6";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.saturday, container, false);
        lv = (ListView) view.findViewById(R.id.saturdayList);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


        connectToDatabase();
        List<String> myList = new ArrayList<String>();
        List<String> myList2 = new ArrayList<String>();
        //populating the list
        c = myDbHelper.rawquery("select * from teachers", null);
        c.moveToFirst();
        while(c.moveToNext()) {
            myList.add(c.getString(2));
            myList2.add(c.getString(3));
        }

        final List<String> finalList = new ArrayList<String>(myList);
        final List<String> finalList2 = new ArrayList<String>(myList2);
        //ArrayAdapter<String> adapter = new ArrayAdapter<Stri2ng>(getActivity(), android.R.layout.simple_list_item_1);



        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_2, android.R.id.text1,finalList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(finalList.get(position));
                text2.setText(finalList2.get(position));
                return view;
            }
        };








        lv.setAdapter(adapter);

    }

    private void connectToDatabase() {
        myDbHelper = new DBHelper(getActivity());
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
}
package com.saivikas.timetable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * Created by coderfreak on 1/8/2016.
 */


public class Friday extends Fragment {

    DBHelper myDbHelper;
    ListView lv;

    DBConnector dbConnect;

    public static final String FRIDAY_ID = "5";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friday, container, false);
        lv = (ListView) view.findViewById(R.id.fridayList);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        dbConnect = new DBConnector(getActivity());
        dbConnect.connectToDatabase();
        List<String> myList = dbConnect.populateList(FRIDAY_ID);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(adapter);

    }
}
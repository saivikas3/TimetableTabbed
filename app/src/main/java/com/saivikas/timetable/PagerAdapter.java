package com.saivikas.timetable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Monday mon = new Monday();
                return mon;
            case 1:
                Tuesday tues = new Tuesday();
                return tues;
            case 2:
                Wednesday wedn = new Wednesday();
                return wedn;
            case 3:
                Thursday thurs = new Thursday();
                return thurs;
            case 4:
                Friday fri = new Friday();
                return fri;
            case 5:
                Saturday sat = new Saturday();
                return sat;
            case 6:
                Teacher teac = new Teacher();
                return teac;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
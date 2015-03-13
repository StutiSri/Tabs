package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import fragments.Mode1;
import fragments.Mode2;
import fragments.Mode3;
import fragments.Rem1;
import fragments.Rem2;
import fragments.Rem3;

/**
 * Created by stuti on 24/2/15.
 */

public class TabsPageAdapter extends FragmentPagerAdapter {

    Fragment mFragReminder, mFragMode;
    //public static TabsPageAdapter mAdapter=null;

    public static int loadRem=1;
    public static int loadMode=1;

    public TabsPageAdapter(FragmentManager fm) {
        super(fm);
        setFragMode();
        setFragReminder();
    }
/*
    public static TabsPageAdapter getInstance(FragmentManager fm){
        if(mAdapter==null) {
            Log.e("TAG","null");
            mAdapter = new TabsPageAdapter(fm);
            mAdapter.mFragReminder = new Tab1AFragment();
            mAdapter.mFragMode = new Tab2AFragment();
        }
        Log.e("TAG","not null");
        return mAdapter;
    }*/

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return mFragReminder;

            case 1:
                return mFragMode;
        }
        return null;


    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

    public void setFragReminder(){
        switch (loadRem) {
            case 1:
                mFragReminder = Rem1.getFragment();
                break;
            case 2:
                mFragReminder = Rem2.getFragment();
                break;
            case 3:
                mFragReminder = Rem3.getFragment();
        }

        Log.e("TAG", "set rem");
    }

    public void setFragMode(){
        Log.e("TAG","set mode");
        switch (loadMode) {
            case 1:
                mFragMode = Mode1.getFragment();
                break;
            case 2:
                mFragMode = Mode2.getFragment();
                break;
            case 3:
                mFragMode = Mode3.getFragment();
        }
    }
}
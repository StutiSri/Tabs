package project.major.stutisonali.tabs;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import adapter.TabsPageAdapter;
import fragments.Mode1;
import fragments.Mode2;
import fragments.Mode3;
import fragments.Rem1;
import fragments.Rem2;
import fragments.Rem3;
import interfaces.FragmentListener;


public class Activity1 extends ActionBarActivity implements ActionBar.TabListener,FragmentListener{

    String[] tabs = {"Location Reminder","Mode Loc"};
    private ViewPager viewPager;
    private TabsPageAdapter mAdapter;
    private ArrayList<Fragment> tabFrags = new ArrayList<Fragment>(2);
    private Fragment fragToLoad = null;
    FragmentTransaction transaction;

    public static int loadRem=1,loadMode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        initialize();

    }
    private void initialize(){
        viewPager = (ViewPager) findViewById(R.id.pager);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tabFrags.add(Rem1.getFragment());
        tabFrags.add(Mode1.getFragment());

        mAdapter = new TabsPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);

        for (String tab_name : tabs) {
            Log.e("RAD","for");
            Log.e("error", "" + actionBar);
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        // actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        Log.e("RAD","nav");
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                Log.e("pageNumber", "" + position);

                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        Log.e("RAD","set listnr");
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
        /*fragToLoad = tabFrags.get(tab.getPosition());
        fragmentTransaction.replace(android.R.id.content,fragToLoad);*/
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void callNextRemActivity(){


    }

    public void callNextModeActivity(){


    }

    public void setFragReminder(){
        switch (loadRem) {
            case 1:
                tabFrags.set(0, Rem1.getFragment());
                break;
            case 2:
                tabFrags.set(0, Rem2.getFragment());
                break;
            case 3:
                tabFrags.set(0, Rem3.getFragment());
        }

        Log.e("TAG", "set rem");
    }

    public void setFragMode(){
        Log.e("TAG","set mode");
        switch (loadMode) {
            case 1:
                tabFrags.set(1, Mode1.getFragment());
                break;
            case 2:
                tabFrags.set(1, Mode2.getFragment());
                break;
            case 3:
                tabFrags.set(1, Mode3.getFragment());
        }
    }
}

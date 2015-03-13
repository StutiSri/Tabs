package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import adapter.TabsPageAdapter;
import interfaces.FragmentListener;
import project.major.stutisonali.tabs.R;

/**
 * Created by stuti on 24/2/15.
 */
public class Rem1 extends Fragment {

    public static Rem1 fragment1a = null;
    public String text="Rem1";
    public EditText edText;
    private Button bTo1b;
    private FragmentListener mCallback;

    public static Rem1 getFragment(){
        if(fragment1a == null)
            fragment1a = new Rem1();
        return fragment1a;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab1a,null);
        Log.e("TAG", "OnCreate1");
        edText = (EditText)rootView.findViewById(R.id.etTab1a);
        Log.e("TAG", "OnCreate2");
        edText.setText(text);
        Log.e("TAG", "OnCreate3");
        bTo1b = (Button)rootView.findViewById(R.id.bto1b);
        Log.e("TAG", "OnCreate4");
        bTo1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("RAD","onClick");
                TabsPageAdapter.loadRem = 2;
                //TabsPageAdapter.mAdapter.setFragReminder(new Tab1BFragment());
                mCallback.setViewPager(0,Rem2.getFragment());
            }
        });
        Log.e("TAG", "OnCreate5");
        return rootView;
    }
    @Override
    public void onPause() {
        super.onPause();
        text = edText.getEditableText().toString();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (FragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


}

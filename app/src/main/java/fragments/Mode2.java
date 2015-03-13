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
public class Mode2 extends Fragment {

    public static Mode2 fragment2b = null;
    public String text="Mode2";
    public EditText edText;
    private Button bTo2c;
    private FragmentListener mCallback;

    public static Mode2 getFragment(){
        if(fragment2b == null)
            fragment2b = new Mode2();
        return fragment2b;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2b,null);
        edText = (EditText)rootView.findViewById(R.id.etTab2b);
        edText.setText(text);
        bTo2c = (Button)rootView.findViewById(R.id.bto2c
        );
        bTo2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("RAD", "onClick");
                TabsPageAdapter.loadMode = 3;
                //TabsPageAdapter.mAdapter.setFragMode(new Tab2CFragment());
                mCallback.setViewPager(1,Mode2.getFragment());
            }
        });
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

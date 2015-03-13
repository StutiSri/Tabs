package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
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
public class Rem2 extends ActionBarActivity {

    public String text = "Rem2";
    public EditText edText;
    private Button bTo1c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1b);
    }
        edText = (EditText)findViewById(R.id.etTab1b);
        edText.setText(text);
        bTo1c = (Button)findViewById(R.id.bto1c);
        bTo1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("RAD", "onClick");
                TabsPageAdapter.loadRem = 3
            }
        });
        

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

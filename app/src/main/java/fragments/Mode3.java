package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import project.major.stutisonali.tabs.R;

/**
 * Created by stuti on 24/2/15.
 */
public class Mode3 extends Fragment {

    public static Mode3 fragment2c = null;
    public String text="Mode3";
    public EditText edText;

    public static Mode3 getFragment(){
        if(fragment2c == null)
            fragment2c = new Mode3();
        return fragment2c;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2c,null);
        edText = (EditText)rootView.findViewById(R.id.etTab2c);
        edText.setText(text);
        return rootView;
    }
    @Override
    public void onPause() {
        super.onPause();
        text = edText.getEditableText().toString();
    }

}

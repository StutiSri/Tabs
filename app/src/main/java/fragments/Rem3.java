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
public class Rem3 extends Fragment {

    public static Rem3 fragment1c = null;
    public String text="Rem3";
    public EditText edText;

    public static Rem3 getFragment(){
        if(fragment1c == null)
            fragment1c = new Rem3();
        return fragment1c;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1c,null);
        edText = (EditText)rootView.findViewById(R.id.etTab1c);
        edText.setText(text);
        return rootView;
    }
    @Override
    public void onPause() {
        super.onPause();
        text = edText.getEditableText().toString();
    }
}

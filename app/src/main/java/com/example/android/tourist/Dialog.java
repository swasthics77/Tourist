package com.example.android.tourist;

/**
 * Created by swasthi_cs77 on 12-Apr-15.
 */
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Dialog extends DialogFragment {
public static String M="Driving";

    public Dialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_fragment, container);

        TextView text= (TextView) view.findViewById(R.id.textDist);
        TextView text1= (TextView) view.findViewById(R.id.textTime);
       // getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
       getDialog().setTitle(M);


        String distance=Detail.dists;
        String time=Detail.times;

        text.setText(distance);
        text1.setText(time);
        M="Driving";

        return view;
    }
}
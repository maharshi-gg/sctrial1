package com.example.ipt02.spotchecktrial1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    CalendarView cv;
    Context context;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_main);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editText = (EditText) view.findViewById(R.id.editText);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCalendarView();
            }
        });
    }

    public void getCalendarView() {

        LinearLayout ll= (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.calendarview, null, false);
        cv = (CalendarView) ll.getChildAt(0);




        AlertDialog alert = new AlertDialog.Builder(getActivity())
                .setTitle("Calendar")
                .setMessage("Select Date")
                .setView(ll)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setDate(cv);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // leave dialog box
                    }
                }).show();
    }

    public void setDate(CalendarView cv) {
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                setDate2();
            }
        });
    }
    public void setDate2(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat ss = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String currentdate= ss.format(date);
        EditText editText = (EditText) getActivity().findViewById(R.id.editText);
        editText.setText(currentdate);

    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        context = getActivity();
    }

}
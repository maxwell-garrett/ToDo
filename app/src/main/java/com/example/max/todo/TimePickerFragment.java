package com.example.max.todo;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;


public class TimePickerFragment extends DialogFragment  {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String[] time = getArguments().getString("time").split("-");

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);


        return new TimePickerDialog(getActivity(), (CreateToDoActivity) getActivity(), hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }


}

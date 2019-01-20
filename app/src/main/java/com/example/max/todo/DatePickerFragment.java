package com.example.max.todo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;



public class DatePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String[] date = getArguments().getString("date").split("-");
        int dayOfMonth = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        return new DatePickerDialog(getActivity(), (CreateToDoActivity) getActivity(), year, month, dayOfMonth);
    }


}

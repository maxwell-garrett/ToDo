package com.example.max.todo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity());
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        ((CreateToDoActivity) getActivity()).editDueTime(year, month, dayOfMonth);
    }
}

package com.example.max.todo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.time.LocalDateTime;

public class CreateToDoActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private LocalDateTime dueTime = LocalDateTime.from(LocalDateTime.now());
    private LocalDateTime creationTime = LocalDateTime.from(LocalDateTime.now());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do);
    }

    public void onAcceptClick(View v) {
        String taskName = ((EditText) findViewById(R.id.task_name)).getText().toString();
        String taskDesc = ((EditText) findViewById(R.id.task_desc)).getText().toString();
        ToDoManager manager = ToDoManager.getInstance();

        ToDoTask task = new ToDoTask(dueTime, creationTime, taskName, taskDesc);
        manager.addToDo(task);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onRejectClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showTimePickerDialog(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("time", Integer.toString(dueTime.getHour()) + "-" + Integer.toString(dueTime.getMinute()));

        DialogFragment newFragment = new TimePickerFragment();
        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("date", Integer.toString(dueTime.getDayOfMonth()) + "-" +
                Integer.toString(dueTime.getMonthValue()) + "-" +
                Integer.toString(dueTime.getYear()));

        DialogFragment newFragment = new DatePickerFragment();
        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        dueTime = dueTime.withHour(hourOfDay);
        dueTime = dueTime.withMinute(minute);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dueTime = dueTime.withYear(year);
        dueTime = dueTime.withMonth(month);
        dueTime = dueTime.withDayOfMonth(dayOfMonth);
    }
}

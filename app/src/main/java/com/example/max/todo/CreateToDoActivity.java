package com.example.max.todo;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDateTime;

public class CreateToDoActivity extends AppCompatActivity {
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
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void editDueTime(int year, int month, int dayOfMonth) {
        dueTime.withYear(year);
        dueTime.withMonth(month);
        dueTime.withDayOfMonth(dayOfMonth);
    }

    public void editDueTime(int hourOfDay, int minute) {
        dueTime.withHour(hourOfDay);
        dueTime.withMinute(minute);
    }
}

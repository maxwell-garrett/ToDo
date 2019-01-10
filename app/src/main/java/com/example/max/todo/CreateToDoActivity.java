package com.example.max.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDateTime;

public class CreateToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do);
    }

    public void onAcceptClick(View v) {
        String taskName = ((EditText) findViewById(R.id.task_name)).getText().toString();
        String taskDesc = ((EditText) findViewById(R.id.task_desc)).getText().toString();
        ToDoManager manager = ToDoManager.getInstance();

        ToDoTask task = new ToDoTask(LocalDateTime.from(LocalDateTime.now()),
                LocalDateTime.from(LocalDateTime.now()), taskName, taskDesc);
        manager.addToDo(task);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onRejectClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

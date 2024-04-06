package com.example.madproject_todolist;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.view.View;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        // Retrieve tasks passed from MainActivity
        ArrayList<Task> tasks = getIntent().getParcelableArrayListExtra("tasks");

        if (tasks != null) {
            // Display tasks in ListView
            ListView listView = findViewById(R.id.taskListView);
            TaskAdapter adapter = new TaskAdapter(this, tasks);
            listView.setAdapter(adapter);
        } else {
            // Handle case where no tasks were passed
            // You can display a message or take any other appropriate action
            // For example, display a toast message:
            Toast.makeText(this, "No tasks available", Toast.LENGTH_SHORT).show();
        }
    }

    public void navigateBack(View view) {
        finish(); // Close the current activity to go back
    }
}

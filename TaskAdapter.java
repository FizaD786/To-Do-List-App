package com.example.madproject_todolist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

        private static final int VIEW_TYPE_HEADER = 0;
        private static final int VIEW_TYPE_TASK = 1;

        private List<Task> tasks;

        public TaskAdapter(Context context, List<Task> tasks) {
                super(context, 0, tasks);
                this.tasks = tasks;
        }

        @Override
        public int getViewTypeCount() {
                return 2;
        }

        @Override
        public int getItemViewType(int position) {
                return tasks.get(position).isHeader() ? VIEW_TYPE_HEADER : VIEW_TYPE_TASK;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                int viewType = getItemViewType(position);

                if (convertView == null) {
                        if (viewType == VIEW_TYPE_HEADER) {
                                convertView = inflater.inflate(R.layout.item_task_header, parent, false);
                        } else {
                                convertView = inflater.inflate(R.layout.item_task, parent, false);
                        }
                }

                Task task = getItem(position);

                if (viewType == VIEW_TYPE_HEADER) {
                        TextView headerTextView = convertView.findViewById(R.id.taskHeader);
                        headerTextView.setText(getPriorityString(task.getPriority()));
                } else {
                        TextView nameTextView = convertView.findViewById(R.id.taskName);
                        TextView dueDateTextView = convertView.findViewById(R.id.taskDueDate);
                        TextView timeTextView = convertView.findViewById(R.id.taskTime);
                        TextView priorityTextView = convertView.findViewById(R.id.taskPriority);

                        nameTextView.setText(task.getName());
                        dueDateTextView.setText(task.getDueDate());
                        timeTextView.setText(task.getTime());
                        priorityTextView.setText(getPriorityString(task.getPriority()));
                }

                return convertView;
        }

        private String getPriorityString(int priority) {
                switch (priority) {
                        case Task.PRIORITY_HIGH:
                                return "High Priority";
                        case Task.PRIORITY_MEDIUM:
                                return "Medium Priority";
                        case Task.PRIORITY_LOW:
                                return "Low Priority";
                        default:
                                return "";
                }
        }
}

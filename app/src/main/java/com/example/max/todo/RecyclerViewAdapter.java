package com.example.max.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ToDoManager manager;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView taskName, taskDesc;

        public MyViewHolder(View v) {
            super(v);
            taskName = (TextView) v.findViewById(R.id.taskName);
            taskDesc = (TextView) v.findViewById(R.id.taskDesc);
        }
    }

    public RecyclerViewAdapter(ToDoManager manager) {
        this.manager = manager;
    }


    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ToDoTask t = manager.getTask(position);
        holder.taskName.setText(t.getName());
        holder.taskDesc.setText(t.getDesc());

    }


    @Override
    public int getItemCount() {
        return manager.getNumberOfTasks();
    }
}

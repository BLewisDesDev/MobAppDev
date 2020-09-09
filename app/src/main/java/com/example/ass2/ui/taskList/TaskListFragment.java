package com.example.ass2.ui.taskList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ass2.R;

public class TaskListFragment extends Fragment {

    private TaskListViewModel taskListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        taskListViewModel =
                ViewModelProviders.of(this).get(TaskListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_task_list, container, false);
        final TextView textView = root.findViewById(R.id.text_TaskList);
        taskListViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
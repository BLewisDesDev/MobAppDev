package com.example.ass2.ui.taskList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ass2.Friend;
import com.example.ass2.R;
import com.example.ass2.Task;
import com.example.ass2.friendAdaptor;

import java.util.ArrayList;
import java.util.List;

public class TaskListFragment extends Fragment {

    ListView taskList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_task_list, container, false);

        ArrayList<Task> taskArray = new ArrayList<Task>();

        Task t = new Task("Do stuff" , "Here");
        Task a = new Task("Do stuff" , "Here");
        Task s = new Task("Do stuff" , "Here");
        Task k = new Task("Do stuff" , "Here");

        taskArray.add(t);
        taskArray.add(a);
        taskArray.add(s);
        taskArray.add(k);

        taskAdapter adapter = new taskAdapter(getActivity(), taskArray);
        taskList = (ListView)root.findViewById(R.id.task_list);
        taskList.setAdapter(adapter);


        return root;
    }
}
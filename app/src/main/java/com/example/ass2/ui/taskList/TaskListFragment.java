package com.example.ass2.ui.taskList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ass2.EditTask;
import com.example.ass2.R;
import com.example.ass2.Task;

import java.util.ArrayList;

public class TaskListFragment extends Fragment {

    ListView taskList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_task_list, container, false);

        ArrayList<Task> taskArray = new ArrayList<Task>();

        Task t = new Task("Study" , "Library");
        Task a = new Task("Eat" , "Grilld");
        Task s = new Task("Run" , "Gym");
        Task k = new Task("Sleep" , "Home");

        taskArray.add(t);
        taskArray.add(a);
        taskArray.add(s);
        taskArray.add(k);

        taskAdapter adapter = new taskAdapter(getActivity(), taskArray);
        taskList = (ListView)root.findViewById(R.id.task_list);
        taskList.setAdapter(adapter);

        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Task t = (Task)taskList.getAdapter().getItem(position);

                Toast.makeText(getContext(),"Editing:" + t.getLocation() + t.getTaskName(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), EditTask.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
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

        Task T = new Task("Do stuff" , "Here");
        Task a = new Task("Do stuff" , "Here");
        Task s = new Task("Do stuff" , "Here");
        Task k = new Task("Do stuff" , "Here");

        taskArray.add(T);
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
                String loc = t.getLocation();
                String tas = t.getTaskName();
                Toast.makeText(getContext(), "Editing: " + loc  + tas, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getContext(), EditTask.class);
                intent1.putExtra("Task Name", tas);
                intent1.putExtra("Location", loc);
//                startActivity(intent1);
            }
        });

        return root;
    }
}
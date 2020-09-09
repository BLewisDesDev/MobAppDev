package com.example.ass2.ui.taskList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TaskListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TaskListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is TaskList fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditTask extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        EditText et_tn = (EditText)findViewById(R.id.edit_tskName);
        et_tn.setText(getIntent().getStringExtra("TaskName"));

        EditText et_loc = (EditText)findViewById(R.id.edit_tskLoc);
        et_loc.setText(getIntent().getStringExtra("Location"));

    }
}
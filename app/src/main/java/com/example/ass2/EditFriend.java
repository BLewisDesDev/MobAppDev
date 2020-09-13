package com.example.ass2;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class EditFriend extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_friend);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText et_fn = (EditText)findViewById(R.id.edit_fn);
        et_fn.setText(getIntent().getStringExtra("FirstName"));

        EditText et_ln = (EditText)findViewById(R.id.edit_ln);
        et_ln.setText(getIntent().getStringExtra("LastName"));

        EditText et_g = (EditText)findViewById(R.id.edit_gnd);
        et_g.setText(getIntent().getStringExtra("Gender"));

        EditText et_age = (EditText)findViewById(R.id.edit_age);
        et_age.setText(Integer.toString(getIntent().getIntExtra("Age", 0)));

        EditText et_a = (EditText)findViewById(R.id.edit_add);
        et_a.setText(getIntent().getStringExtra("Address"));

        getIntent().getSerializableExtra("Friend");

    }

    //save(){}

    //delete(){}
}
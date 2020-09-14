package com.example.ass2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.ass2.ui.friendList.FriendListFragment;

public class EditFriend extends AppCompatActivity {

    Button Save, Delete;
    EditText et_fn, et_ln, et_g, et_age, et_a;
    DatabaseManager DBM;
    Boolean recInserted;
    int f_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_friend);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBM = new DatabaseManager(this);

        et_fn = (EditText)findViewById(R.id.edit_fn);
        et_fn.setText(getIntent().getStringExtra("FirstName"));

        et_ln = (EditText)findViewById(R.id.edit_ln);
        et_ln.setText(getIntent().getStringExtra("LastName"));

        et_g = (EditText)findViewById(R.id.edit_gnd);
        et_g.setText(getIntent().getStringExtra("Gender"));

        et_age = (EditText)findViewById(R.id.edit_age);
        et_age.setText(Integer.toString(getIntent().getIntExtra("Age", 0)));

        et_a = (EditText)findViewById(R.id.edit_add);
        et_a.setText(getIntent().getStringExtra("Address"));

        Save = (Button)findViewById(R.id.save_friend);
        Delete = (Button)findViewById(R.id.delete_friend);

    }

    public void save(View v){

        f_id = getIntent().getIntExtra("Friend_ID", 0);

        recInserted = DBM.addRow(
                f_id,
                et_fn.getText().toString(),
                et_ln.getText().toString(),
                et_g.getText().toString(),
                Integer.parseInt(et_age.getText().toString()),
                et_a.getText().toString());

        if (recInserted) {
            Log.i("Success:","Inserting Record");
        }
        else {
            Log.i("Failed:","Inserting Record");
        }

        DBM.close();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void delete(View v){

        DBM.deleteRow(f_id);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
package com.example.ass2;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    DatabaseManager DBM;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_friend_list, R.id.nav_task_list)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Initialise Database and fill with sample data
        DBM = new DatabaseManager(MainActivity.this);

        DBM.addRow(103,"James", "Morrow", "Male", 29, "Second Ave");
        DBM.addRow(104,"Lebron", "James", "Male", 35, "Sydney");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void initialiseFriends(View v) {
//        Button init = (Button)findViewById(R.id.initaliseDatabase);
//        DBM.addRow(103,"James", "Morrow", "Male", 29, "Second Ave");
//        DBM.addRow(104,"Lebron", "James", "Male", 35, "Sydney");
//        DBM.addRow(103,"Lyn", "Momposhi", "Female", 21, "Second Ave");
//        DBM.addRow(104,"Jason", "Bourne", "Male", 39, "Sydney");
//        DBM.addRow(103,"James", "Bond", "Male", 40, "Second Ave");
//        DBM.addRow(104,"Dwayne", "Johnson", "Male", 42, "Sydney");
//        DBM.addRow(103,"Joe", "Rogan", "Male", 53, "Second Ave");
//        DBM.addRow(104,"Rosalia", "Rosie", "Female", 23, "Sydney");
//        DBM.addRow(103,"Ariana", "Grande", "Female", 19, "Second Ave");

    }

    public void clearFriends(View v) {
//        Button clear = (Button)findViewById(R.id.clearDatabase);
//        DBM.clearRecords();
    }

}
package com.example.ass2.ui.friendList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ass2.Friend;
import com.example.ass2.R;

import java.util.ArrayList;

public class friendAdaptor extends ArrayAdapter<Friend> {
    public friendAdaptor(Context context, ArrayList<Friend> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Friend friend = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_friend, parent, false);
        }
        // Lookup view for data population
        TextView fName = (TextView) convertView.findViewById(R.id.f_name);
        TextView lName = (TextView) convertView.findViewById(R.id.l_name);
        // Populate the data into the template view using the data object
        fName.setText(friend.getFirstName());
        lName.setText(friend.getLastName());
        // Return the completed view to render on screen
        return convertView;
    }
}
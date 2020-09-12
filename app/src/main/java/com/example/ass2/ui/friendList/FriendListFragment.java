package com.example.ass2.ui.friendList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ass2.Friend;
import com.example.ass2.R;
import com.example.ass2.friendAdaptor;

import java.util.ArrayList;

public class FriendListFragment extends Fragment {

    public FriendListFragment() {
    }

    ListView friendList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_friend_list, container, false);

        ArrayList<Friend> friendsArray = new ArrayList<Friend>();

        Friend F = new Friend("A", "G", "M", 10, "S");
        Friend r = new Friend("B", "H", "N", 10, "T");
        Friend I = new Friend("C", "I", "O", 10, "U");
        Friend E = new Friend("D", "J", "P", 10, "V");
        Friend N = new Friend("E", "K", "Q", 10, "W");
        Friend D = new Friend("F", "L", "R", 10, "X");

        friendsArray.add(F);
        friendsArray.add(r);
        friendsArray.add(I);
        friendsArray.add(E);
        friendsArray.add(N);
        friendsArray.add(D);

        friendAdaptor adapter = new friendAdaptor(getActivity(), friendsArray);
        friendList = (ListView)root.findViewById(R.id.friend_list);
        friendList.setAdapter(adapter);


        return root;
    }
}
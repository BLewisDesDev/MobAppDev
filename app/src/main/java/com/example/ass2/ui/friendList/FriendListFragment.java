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

public class FriendListFragment extends Fragment {

    public FriendListFragment() {
    }

    ListView friendList;
    String[] vals = {"1sadasdasd", "2asdasdasd", "3asdasda", "asdasdasd4","1sadasdasd", "2asdasdasd", "3asdasda", "asdasdasd4","1sadasdasd", "2asdasdasd", "3asdasda", "asdasdasd4","1sadasdasd", "2asdasdasd", "3asdasda", "asdasdasd4"};
    Friend[] friends;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_friend_list, container, false);

//        friendList = (ListView)root.findViewById(R.id.friend_list);
//        ArrayAdapter<String> friendListAdaptor = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, vals);
//        friendList.setAdapter(friendListAdaptor);

        friendList = (ListView)root.findViewById(R.id.friend_list);
        ArrayAdapter<String> friendListAdaptor = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, vals);
        friendList.setAdapter(friendListAdaptor);

        Friend F = new Friend("A", "G", "M", 10, "S");
        Friend R = new Friend("B", "H", "N", 10, "T");
        Friend I = new Friend("C", "I", "O", 10, "U");
        Friend E = new Friend("D", "J", "P", 10, "V");
        Friend N = new Friend("E", "K", "Q", 10, "W");
        Friend D = new Friend("F", "L", "R", 10, "X");

        friends[0] = F;
        friends[1] = R;
        friends[2] = I;
        friends[3] = E;
        friends[4] = N;
        friends[5] = D;

        return root;
    }
}
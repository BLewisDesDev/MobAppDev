package com.example.ass2.ui.friendList;

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

import com.example.ass2.EditFriend;
import com.example.ass2.ui.editFriend.EditFriendFragment;
import com.example.ass2.Friend;
import com.example.ass2.R;

import java.util.ArrayList;

public class FriendListFragment extends Fragment {

    ListView friendList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_friend_list, container, false);

        ArrayList<Friend> friendsArray = new ArrayList<Friend>();

        Friend F = new Friend("Allen", "Grower", "Male", 10, "Street Street");
        Friend r = new Friend("Bill", "Homer", "N", 100, "Turner Street");
        Friend I = new Friend("Charlie", "Ines", "O", 30, "Upadate Street");
        Friend E = new Friend("Darren", "Jacobs", "P", 20, "Vincent Street");
        Friend N = new Friend("Eric", "Kartman", "Q", 60, "Willow Street");
        Friend D = new Friend("Frank", "Lombardi", "R", 50, "Xavier Street");

        friendsArray.add(F);
        friendsArray.add(r);
        friendsArray.add(I);
        friendsArray.add(E);
        friendsArray.add(N);
        friendsArray.add(D);

        friendAdaptor adapter = new friendAdaptor(getActivity(), friendsArray);
        friendList = (ListView)root.findViewById(R.id.friend_list);
        friendList.setAdapter(adapter);

        friendList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Friend f = (Friend)friendList.getAdapter().getItem(position);
                Toast.makeText(getContext(), "Editing: " + f.getFirstName()  + f.getLastName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), EditFriend.class);
                intent.putExtra("Friend", f);
                startActivity(intent);
            }
        });

        return root;
    }

}

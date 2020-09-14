package com.example.ass2.ui.friendList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ass2.DatabaseManager;
import com.example.ass2.EditFriend;
import com.example.ass2.Friend;
import com.example.ass2.R;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FriendListFragment extends Fragment {

    ListView friendList;
    ArrayList<Friend> friendsArray;
    ArrayList<String> response;
    DatabaseManager DBM;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_friend_list, container, false);

        friendsArray = new ArrayList<Friend>();

        DBM = new DatabaseManager(getContext());
        response = DBM.retrieveRows();

        int i = 0;
        for (String s : response) {
            String str = response.get(i);
            String[] arrOfStr = str.split(", ", 6);
            Friend F = stringToFriend(arrOfStr);
            friendsArray.add(F);
            i++;
        }

        friendAdaptor adapter = new friendAdaptor(getActivity(), friendsArray);
        friendList = (ListView)root.findViewById(R.id.friend_list);
        friendList.setAdapter(adapter);

        friendList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Friend f = (Friend)friendList.getAdapter().getItem(position);
                int f_id = f.getId();
                String fn = f.getFirstName();
                String ln = f.getLastName();
                String g = f.getGender();
                String a = f.getAddress();
                int age = f.getAge();

                Intent intent = new Intent(getContext(), EditFriend.class);

                intent.putExtra("Friend_ID", f_id);
                intent.putExtra("FirstName", fn);
                intent.putExtra("LastName", ln);
                intent.putExtra("Gender", g);
                intent.putExtra("Address", a);
                intent.putExtra("Age", age);

                startActivity(intent);
            }
        });

        return root;
    }

    private Friend stringToFriend(String[] s){

        String fn = s[1];
        String ln = s[2];
        String g = s[3];
        int age = parseInt(s[4]);
        String add = s[5];

        Friend f = new Friend(fn,ln,g,age,add);

        return f;
    }

}

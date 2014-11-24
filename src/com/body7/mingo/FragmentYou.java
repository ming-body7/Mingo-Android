package com.body7.mingo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class FragmentYou extends Fragment {
	
	private MainActivity myMainActivity;
	private ArrayList<Task> data;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.fragment_you, container, false);
           ListView listView =(ListView)view.findViewById(R.id.listViewYou);
           //data = new ArrayList<Task>();
           myMainActivity = (MainActivity) getActivity();
           data = myMainActivity.data;
           listView.setAdapter(new ListViewAdapter(getActivity(),data));
           
           listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               public void onItemClick(AdapterView<?> av, View view, int i, long l) {
            	   String s = (String)av.getItemAtPosition(i);
            	   myMainActivity.myRunningView.onClickStart(s);                 
               }
           });
         return view;
    }

    }
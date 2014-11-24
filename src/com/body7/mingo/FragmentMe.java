package com.body7.mingo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;




  public class FragmentMe extends Fragment {
	  
	  private MainActivity myMainActivity;
	  private ArrayList<Task> data;
	  
	  @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
	           View view = inflater.inflate(R.layout.fragment_me, container, false);
	           final Button beginButton = (Button)view.findViewById(R.id.beginButton);
	           final EditText newTaskName = (EditText)view.findViewById(R.id.newTaskName);
	           myMainActivity = (MainActivity) getActivity();
	           data = myMainActivity.data;
	           
	           ListView controllList = (ListView)view.findViewById(R.id.listViewControll);
	           String[] controllArray = new String[]{"List", "History", "Summary", "Settings"};
	           final ArrayList<String> list = new ArrayList<String>();
	           for (int i = 0; i < controllArray.length; ++i) {
	        	      list.add(controllArray[i]);
	        	    }
	           
	           final StableArrayAdapter controllAdapter = new StableArrayAdapter(getActivity(),R.layout.controll_view,list);
	           controllList.setAdapter(controllAdapter);
	           controllList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	               public void onItemClick(AdapterView<?> av, View view, int i, long l) {
	                   Toast.makeText(getActivity(), "myPos "+i, Toast.LENGTH_LONG).show();
	               }
	           });
	           
	           beginButton.setOnClickListener(new OnClickListener() {
	        	   public void onClick(View v)
	        	   {
	        		   String s = newTaskName.getText().toString();
	        		   if(s.length()==0)
	        		   {
	        			   s = "Default Task";
	        		   }
	        		   Task t = new Task("Ming",s,"5");
	        		   data.add(t);
	        		   myMainActivity.myRunningView.onClickStart(s);
	        		   newTaskName.setText("");
 	        
	        	   } 
	           	});
	           return view;
	    }
	  private class StableArrayAdapter extends ArrayAdapter<String> {

		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
		      super(context, textViewResourceId, objects);
		      for (int i = 0; i < objects.size(); ++i) {
		        mIdMap.put(objects.get(i), i);
		      }
		    }

		    @Override
		    public long getItemId(int position) {
		      String item = getItem(position);
		      return mIdMap.get(item);
		    }

		    @Override
		    public boolean hasStableIds() {
		      return true;
		    }

		  }

  }
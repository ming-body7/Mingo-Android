package com.body7.mingo;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{
	
	
	private FragmentActivity activity;
	private static ArrayList<Task> data;
	
	
	
	
	
	private static LayoutInflater inflater=null;
	
	public ListViewAdapter(FragmentActivity activity, ArrayList<Task> data) {
		super();
		this.activity = activity;
		this.data = data;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//data = new ArrayList<Task>(3);
		//Task t1 = new Task("Ming","ECE535","3");
		//Task t2 = new Task("Ming","CIS525","8");
		//Task t3 = new Task("Ming","Android Project","15");
		//data.add(t1);
		//data.add(t2);
		//data.add(t3);
	}

	@Override
	public int getCount() {

		return data.size();
		//return 3;
	}

	@Override
	public String getItem(int position) {
		String s = data.get(position).task;
		//String s = "lol";
		return s;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
    public static class ViewHolder{
         
        public TextView textName;
        public TextView textTask;
        public TextView textTime;

    }
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View vi = convertView;
        vi = inflater.inflate(R.layout.view_task, null);
        TextView textName = (TextView)vi.findViewById(R.id.textName);
        TextView textTask = (TextView)vi.findViewById(R.id.textTask); 
        TextView textTime = (TextView)vi.findViewById(R.id.textTime);
        textName.setText(data.get(position).name);
        textTask.setText(data.get(position).task);
        textTime.setText(data.get(position).time);
        return vi;
	}

}

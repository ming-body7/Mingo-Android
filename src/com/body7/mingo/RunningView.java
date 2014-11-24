package com.body7.mingo;






import java.util.ArrayList;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RunningView extends Fragment{

	private MainActivity myMainActivity;
	 CountDownView mTimerView;
	 TextView runningTaskView;
	 private boolean timerHasStarted = false;
	 private Button startButton;
	 private ArrayList<Task> data;
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	    	View view = inflater.inflate(R.layout.fragment_running, container, false);
	    	myMainActivity = (MainActivity) getActivity();
	    	data = myMainActivity.data;
	    	init(view);	
	        return view;
	    }

	
	
    private void init(View view) {
   
      startButton = (Button) view.findViewById(R.id.startButton);
      mTimerView = (CountDownView)view.findViewById(R.id.tomato_clock);
      runningTaskView = (TextView)view.findViewById(R.id.runningTaskName); 
      view.setBackgroundColor(Color.GRAY);
      view.setClickable(true);
      view.setOnClickListener(
    		  new OnClickListener() {
	        	   public void onClick(View v)
	        	   {
	        		   
	        		   //Toast.makeText(getActivity(), "LOLLLLLLLL", Toast.LENGTH_LONG).show();
	        		   Intent intent = new Intent(getActivity(), RunningActivity.class);
	        		   // EditText editText = (EditText) findViewById(R.id.edit_message);
	        		    //String message = editText.getText().toString();
	        		   long leftTime = mTimerView.getLeftValue();
	        	
	        		    intent.putExtra("Data", leftTime);
	        		   
	        		    startActivity(intent);
	        
	        	   } 
	           	}
    		  );
  	  startButton.setOnClickListener(new OnClickListener() {
  	    public void onClick(View v)
  	    {
  	        timerClick();
 	        
  	    } 
  	});
  	  
  	  
    }
    public void timerClick()
    {
    	if(timerHasStarted == false)
	        {
    		mTimerView.start(25*60000);
	   	    timerHasStarted = true;
	   	    startButton.setText("Cancel");
	        }
	        else
	        {
	        	
	        	timerHasStarted = false;
	        	mTimerView.stop();
	        	startButton.setText("Start");
	        }
    }



	
	public void onClickStart(String taskName) {
		timerHasStarted = false;
		timerClick();
		runningTaskView.setText(taskName);
	}
	

}

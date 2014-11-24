package com.body7.mingo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class RunningActivity extends Activity {
	
	CountDownView mTimerView;
	ImageButton tomatoButton;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
        //mTimerView = new CountDownView(null, null);
        mTimerView = (CountDownView)findViewById(R.id.tomato_clock2);
        tomatoButton = (ImageButton)findViewById(R.id.imageButtonTomato);
        
        tomatoButton.setOnClickListener(new OnClickListener() {
     	   public void onClick(View v)
     	   {
     		  finish();
 
     	   } 
        	}
		  );
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long left = extras.getLong("Data");
            if(left==0)
            	mTimerView.start(25*60000);
            else
            mTimerView.start(left);
        }
        else
        {
        	mTimerView.start(25*60000);
        }
        final ActionBar actionBar = getActionBar();
        //mTimerView = (CountDownView) findViewById(R.id.tomato_clock2);
        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; goto parent activity.
	            this.finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}

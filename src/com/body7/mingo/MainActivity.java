package com.body7.mingo;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private ViewPager myViewPager;
	private MyPagerAdapter myPagerAdapter;
	RunningView myRunningView;
	
	ArrayList<Task> data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		data = new ArrayList<Task>();
		initData(data);
		myRunningView = (RunningView)getSupportFragmentManager().findFragmentById(R.id.running_fragment);
			
		myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), data);
		final ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(0xffcccccc));
        
        
        myViewPager = (ViewPager) findViewById(R.id.pager);
        myViewPager.setAdapter(myPagerAdapter);
        myViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                
                actionBar.setSelectedNavigationItem(position);
            }
        });
        
        for (int i = 0; i < myPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(myPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
       
 
	}
	
    


@Override
public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
}

@Override
public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    myViewPager.setCurrentItem(tab.getPosition());
}

@Override
public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
}

private void initData(ArrayList<Task> data){
	Task t1 = new Task("Ming","ECE535","3");
	Task t2 = new Task("Ming","CIS525","8");
	Task t3 = new Task("Ming","Android Project","15");
	data.add(t1);
	data.add(t2);
	data.add(t3);
	
	}
}

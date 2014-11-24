package com.body7.mingo;


import java.util.ArrayList;

import com.body7.mingo.FragmentYou;
import com.body7.mingo.FragmentMe;

//import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
	
	private ArrayList<Task> data;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    
    public MyPagerAdapter(FragmentManager fm, ArrayList<Task> data) {
        super(fm);
        this.data = data;
    }
    
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FragmentYou();

            default:
                return new FragmentMe();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
        	case 0:
        		return "You";
        	default:
        		return "Me";
        }
    }
}
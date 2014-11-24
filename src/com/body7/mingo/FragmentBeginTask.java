package com.body7.mingo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pascalwelsch.holocircularprogressbar.HoloCircularProgressBar;

public class FragmentBeginTask extends Fragment {
	
	private HoloCircularProgressBar mHoloCircularProgressBar;
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	    	View view = inflater.inflate(R.layout.fragment_begintask, container, false);
	    	
	    	//mHoloCircularProgressBar = (HoloCircularProgressBar)getActivity().findViewById(
	                //R.id.holoCircularProgressBar);
	        return view;
	    }
	 
}

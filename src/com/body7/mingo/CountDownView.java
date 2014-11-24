package com.body7.mingo;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.Runnable;


public class CountDownView extends TextView
{
  private long mUntil;
  private Handler mHandler;
  private Runnable mCallback;
  private boolean mPaused,mRunning;

  public CountDownView(Context context, AttributeSet attrs)
  {
    super(context,attrs);

    mHandler = new Handler();
    mCallback = new Runnable() { 
      public void run() {
        if (mRunning && !mPaused) {
          CountDownView.this.tick();
          mHandler.postDelayed(mCallback, 1000);
        }
      }
    };
  }

  public void start(long durationMillis) { start(durationMillis,0); }
  public void start(long durationMillis, long startTime)
  {
    startTime = (startTime == 0) ? System.currentTimeMillis() : startTime;
    mUntil = startTime + durationMillis+100;

    mPaused = false;
    mRunning = true;
    mHandler.postDelayed(mCallback, 0);
  }

  public void stop()
  {
    setText("00:00");
    mRunning = false;
  }
  public void pause()
  {
    mPaused = true;
  }
  public void unpause()
  {
    mPaused = false;
    mHandler.postDelayed(mCallback, 0);
  }

  public long getLeftValue()
  {
	  long left = mUntil - System.currentTimeMillis();
	  if(left<0) return 0;
	  return left;
  }
  protected void tick() 
  {
    long left = mUntil - System.currentTimeMillis();
    long min = Math.abs((long)(left / 60000));
    long sec = Math.abs((long)((left - min) / 1000) % 60);
    if(sec<10)
    	setText((left < 0 ? "-" : "" )+ min+":0"+sec);	
    else
    setText((left < 0 ? "-" : "" )+ min+":"+sec);
  }
}

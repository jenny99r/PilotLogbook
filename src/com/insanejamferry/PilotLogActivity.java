package com.insanejamferry;

import java.util.Calendar;

import com.insane.jam.ferry.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class PilotLogActivity extends Activity {
	private TextView dateDisplay;
	private TextView breaksOffDisplay;
	private TextView breaksOnDisplay;
	
	private static final int DATE_DIALOG_ID = 0;
	private static final int BREAKS_OFF_TIME_DIALOG_ID = 1;
	private static final int BREAKS_ON_TIME_DIALOG_ID = 2;
	
	private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
				@Override
                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    updateFlightDateDisplay(dayOfMonth, monthOfYear, year);
                }
            };
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_entry);
        
        dateDisplay = (TextView) findViewById(R.id.flightDate);
        
        dateDisplay.setOnTouchListener(createOnTouchListenerForDialog(DATE_DIALOG_ID));
        
        final Calendar c = Calendar.getInstance();      
        updateFlightDateDisplay(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        
        breaksOffDisplay = (TextView) findViewById(R.id.breaksOff);
        breaksOnDisplay = (TextView) findViewById(R.id.breaksOn);
        
        breaksOffDisplay.setOnTouchListener(createOnTouchListenerForDialog(BREAKS_OFF_TIME_DIALOG_ID));
        breaksOnDisplay.setOnTouchListener(createOnTouchListenerForDialog(BREAKS_ON_TIME_DIALOG_ID));
        
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        
        updateTimeDisplay(breaksOffDisplay, hour, minute);
        updateTimeDisplay(breaksOnDisplay, hour, minute);
        
    }
    
    private View.OnTouchListener createOnTouchListenerForDialog(final int dialogId) {
    	return new View.OnTouchListener() {
        	@Override
            public boolean onTouch(View v, MotionEvent arg) {
                showDialog(dialogId);
                return true;
        	}
			
        };
    }
    
    private void updateFlightDateDisplay(int day, int month, int year) {
    	dateDisplay.setText(
    			new StringBuilder()
    				// Month is 0 based so add 1
    				.append(day).append("-")
    				.append(month + 1).append("-")
    				.append(year).append(" "));

    }
    
    private void updateTimeDisplay(TextView textView, int hour, int minute) {
    	textView.setText(new StringBuilder().append(hour).append(":").append(minute));
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
            return new DatePickerDialog(this,
                        dateSetListener,
                        2012, 3, 12);
//        case BREAKS_OFF_TIME_DIALOG_ID: 
//        	return new TimePickerDialog(this, new TimePickerListener(breaksOffDisplay), 10, 15, true);
//        case BREAKS_ON_TIME_DIALOG_ID: 
//        	return new TimePickerDialog(this, new TimePickerListener(breaksOnDisplay), 10, 15, true);
        }
        return null;
    }
    
   
    
    private class TimePickerListener implements TimePickerDialog.OnTimeSetListener {
		
	  private TextView textView;
	  
	  public TimePickerListener(TextView textView) {
		  this.textView = textView;
	  }
	  
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			updateTimeDisplay(textView, hourOfDay, minute);
			
		}
	};
} 
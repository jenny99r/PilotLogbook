package com.insane.jam.ferry;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class PilotLogActivity extends Activity {
	private TextView dateDisplay;
	private static final int DATE_DIALOG_ID = 0;
	
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
        
        dateDisplay.setOnTouchListener(new View.OnTouchListener() {
        	@Override
            public boolean onTouch(View v, MotionEvent arg) {
                showDialog(DATE_DIALOG_ID);
                return true;
        	}
			
        });
        
        final Calendar c = Calendar.getInstance();      
        updateFlightDateDisplay(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));



    }
    
    private void updateFlightDateDisplay(int day, int month, int year) {
    	dateDisplay.setText(
    			new StringBuilder()
    				// Month is 0 based so add 1
    				.append(day).append("-")
    				.append(month + 1).append("-")
    				.append(year).append(" "));

    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
            return new DatePickerDialog(this,
                        dateSetListener,
                        2012, 3, 12);
        }
        return null;
    }
}
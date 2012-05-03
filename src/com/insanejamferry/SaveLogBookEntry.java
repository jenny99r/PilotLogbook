package com.insanejamferry;

import com.insane.jam.ferry.R;
import com.insanejamferry.db.LogBookData;
import com.insanejamferry.domain.LogBookEntry;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SaveLogBookEntry implements OnClickListener {
	
	private LogBookEntryActivity logBookEntryActivity;
	private LogBookData logBookData;

	public SaveLogBookEntry(LogBookEntryActivity logBookEntryActivity, LogBookData logBookData) {
		this.logBookEntryActivity = logBookEntryActivity;
		this.logBookData = logBookData;
	}

	@Override
	public void onClick(View v) {
		
		TextView fromAirfield = (TextView) logBookEntryActivity.findViewById(R.id.fromAirfield);
		TextView toAirfield = (TextView) logBookEntryActivity.findViewById(R.id.toAirfield);
		
		LogBookEntry logBookEntry = new LogBookEntry(fromAirfield.getText().toString(), toAirfield.getText().toString());
		
		logBookData.addLogBookEntry(logBookEntry);
	}

}

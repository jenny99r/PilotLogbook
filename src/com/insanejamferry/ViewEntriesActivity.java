package com.insanejamferry;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

import com.insane.jam.ferry.R;
import com.insanejamferry.db.LogBookData;
import com.insanejamferry.db.PilotLogDatabaseHelper;

public class ViewEntriesActivity extends ListActivity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_entries);
        
        Cursor cursor = new LogBookData(new PilotLogDatabaseHelper(this)).getLogBook();
        showLogEntries(cursor);
        
	}
	
	private void showLogEntries(Cursor cursor) {
		this.startManagingCursor(cursor);
		int [] to = {R.id.itemId, R.id.itemFrom, R.id.itemTo};
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.entry_item, cursor, LogBookData.FROM, to);
		setListAdapter(adapter);
	}

}

package com.insanejamferry.db;

import static android.provider.BaseColumns._ID;
import static com.insanejamferry.db.PilotLogDatabaseHelper.LOG_BOOK_FROM_AIRFIELD;
import static com.insanejamferry.db.PilotLogDatabaseHelper.LOG_BOOK_TABLE;
import static com.insanejamferry.db.PilotLogDatabaseHelper.LOG_BOOK_TO_AIRFIELD;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.insanejamferry.domain.LogBookEntry;

public class LogBookData {
	
	public static final String[] FROM = { _ID, LOG_BOOK_FROM_AIRFIELD, LOG_BOOK_TO_AIRFIELD};
	private static String ORDER_BY = _ID + " DESC";
	
	private PilotLogDatabaseHelper databaseHelper;

	public LogBookData(PilotLogDatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	public void addLogBookEntry(LogBookEntry logBookEntry) {
		SQLiteDatabase database = databaseHelper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put(LOG_BOOK_FROM_AIRFIELD, logBookEntry.getFromAirfield());
		values.put(LOG_BOOK_TO_AIRFIELD, logBookEntry.getToAirfield());
		
		database.insertOrThrow(LOG_BOOK_TABLE, null, values);
	}

	
	public Cursor getLogBook() {  // change to pass in the activity
	SQLiteDatabase db = databaseHelper.getReadableDatabase();
	Cursor cursor = db.query(LOG_BOOK_TABLE, FROM, null, null, null,
	                         null, ORDER_BY);
	
		
		return cursor;
	}
}

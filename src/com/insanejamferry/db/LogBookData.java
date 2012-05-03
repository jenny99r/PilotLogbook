package com.insanejamferry.db;

import static com.insanejamferry.db.PilotLogDatabaseHelper.LOG_BOOK_FROM_AIRFIELD;
import static com.insanejamferry.db.PilotLogDatabaseHelper.LOG_BOOK_TABLE;
import static com.insanejamferry.db.PilotLogDatabaseHelper.LOG_BOOK_TO_AIRFIELD;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.insanejamferry.domain.LogBookEntry;

public class LogBookData {
	
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

}

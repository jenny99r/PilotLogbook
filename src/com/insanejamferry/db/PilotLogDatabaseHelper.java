package com.insanejamferry.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class PilotLogDatabaseHelper  extends SQLiteOpenHelper {
	
	public static final String LOG_BOOK_TABLE = "LOG_BOOK";
	public static final String LOG_BOOK_FROM_AIRFIELD = "FROM_AIRFIELD";
	public static final String LOG_BOOK_TO_AIRFIELD = "TO_AIRFIELD";
	
	
	private static final String DATABASE_NAME = "pilotlog.db";
	private static final int DATABASE_VERSION = 1;

	public PilotLogDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + LOG_BOOK_TABLE + 
				    " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "  +
				           LOG_BOOK_FROM_AIRFIELD + " TEXT, " +
				           LOG_BOOK_TO_AIRFIELD + " TEXT);"
				);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + LOG_BOOK_TABLE);
		onCreate(db);
		
	}

}

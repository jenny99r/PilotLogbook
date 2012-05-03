package com.insanejamferry.db;

import org.junit.Test;

import com.insanejamferry.domain.LogBookEntry;

import android.database.sqlite.SQLiteDatabase;
import static org.mockito.Mockito.*;

public class LogBookDataTest {
	
	private PilotLogDatabaseHelper database = mock(PilotLogDatabaseHelper.class);
	private SQLiteDatabase db = mock(SQLiteDatabase.class);
	private LogBookEntry logBookEntry = mock(LogBookEntry.class);
	
	private LogBookData logBookData = new LogBookData(database);
	
	@Test
	public void shouldSaveLogBookEntry() {
		when(database.getWritableDatabase()).thenReturn(db);
		
		logBookData.addLogBookEntry(logBookEntry);
		
		
		
		verify(db).insertOrThrow("", null, null);
		verify(logBookEntry).getFromAirfield();
		verify(logBookEntry).getToAirfield();
		
	}

}

package com.insanejamferry;

public class DateExtracter {
	
	private static final char SEPERATOR = '-';
	
	private final int day;
	private final int month;
	private final int year;
	
	public DateExtracter(String date) {
		String[] dateSplit = date.split("" + SEPERATOR);
		day = Integer.valueOf(dateSplit[0]);
		month = Integer.valueOf(dateSplit[1]);
		year = Integer.valueOf(dateSplit[2]);
}
	
	public DateExtracter(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public String getDate() {
		return "" + day + SEPERATOR +
				+ month + SEPERATOR +
				year;
	}
}

package com.insanejamferry;

public class TimeExtracter {
	
	private static final char SEPERATOR = ':';
	
	private final int hour;
	private final int minute;
	
	public TimeExtracter(String time) {
		this(time.split("" + SEPERATOR));
		
	}
	
	private TimeExtracter(String[] timeSplit) {
		this(Integer.valueOf(timeSplit[0]), Integer.valueOf(timeSplit[1]));
	}
	
	public TimeExtracter(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
		
	}
	
	public String getTime() {
		String minuteStr;
		if (minute < 10) {
			minuteStr = "0" + minute;
		} else {
			minuteStr = String.valueOf(minute);
		}
		return "" + hour + SEPERATOR +  minuteStr;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}

}

package com.insanejamferry.domain;

public class LogBookEntry {
	
	private String fromAirfield;
	private String toAirfield;
	
	public LogBookEntry(String fromAirfield, String toAirfield) {
		this.fromAirfield = fromAirfield;
		this.toAirfield =  toAirfield;
	}

	public String getFromAirfield() {
		return fromAirfield;
	}

	public String getToAirfield() {
		return toAirfield;
	}

}

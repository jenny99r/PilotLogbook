package com.insanejamferry;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

public class TimeExtracterTest {

	@Test
	public void shouldReturnTimePartsFromString() {
		TimeExtracter extracter = new TimeExtracter("12:13");
		
		assertThat(extracter.getHour(), Is.is(12));
		assertThat(extracter.getMinute(), Is.is(13));
	}
	
	@Test
	public void shouldReturnTimePartsFromStringWhenMinuteIsSingle() {
		TimeExtracter extracter = new TimeExtracter("12:03");
		
		assertThat(extracter.getHour(), Is.is(12));
		assertThat(extracter.getMinute(), Is.is(3));
	}
	
	@Test
	public void shouldReturnTimePartsFromStringWhenHourIsSingle() {
		TimeExtracter extracter = new TimeExtracter("2:13");
		
		assertThat(extracter.getHour(), Is.is(2));
		assertThat(extracter.getMinute(), Is.is(13));
	}
	
	@Test
	public void shouldReturnStringTime() {
		TimeExtracter extracter = new TimeExtracter(12, 14);
		
		assertThat(extracter.getTime(), Is.is("12:14"));
	}
	
	@Test
	public void shouldReturnStringTimeWhenMinuteIsSingle() {
		TimeExtracter extracter = new TimeExtracter(12, 4);
		
		assertThat(extracter.getTime(), Is.is("12:04"));
	}
	
	@Test
	public void shouldReturnStringTimeWhenHourIsSingle() {
		TimeExtracter extracter = new TimeExtracter(2, 14);
		
		assertThat(extracter.getTime(), Is.is("2:14"));
	}
	
	@Test
	public void shouldReturnStringTimeWhenMinuteIsZero() {
		TimeExtracter extracter = new TimeExtracter(2, 0);
		
		assertThat(extracter.getTime(), Is.is("2:00"));
	}
	
	@Test
	public void shouldReturnStringTimeWhenHourIsZero() {
		TimeExtracter extracter = new TimeExtracter(0, 13);
		
		assertThat(extracter.getTime(), Is.is("0:13"));
	}

}

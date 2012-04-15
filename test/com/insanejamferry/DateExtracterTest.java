package com.insanejamferry;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

public class DateExtracterTest {

	@Test
	public void shouldReturnDatePartsFromString() {
		DateExtracter extracter = new DateExtracter("14-11-2012");
		
		assertThat(extracter.getDay(), Is.is(14));
		assertThat(extracter.getMonth(), Is.is(11));
		assertThat(extracter.getYear(), Is.is(2012));
	}
	
	@Test
	public void shouldReturnDatePartsFromStringWithSingleMonth() {
		DateExtracter extracter = new DateExtracter("14-3-2012");
		
		assertThat(extracter.getDay(), Is.is(14));
		assertThat(extracter.getMonth(), Is.is(3));
		assertThat(extracter.getYear(), Is.is(2012));
	}
	
	@Test
	public void shouldReturnDatePartsFromStringWithSingleDay() {
		DateExtracter extracter = new DateExtracter("3-11-2012");
		
		assertThat(extracter.getDay(), Is.is(3));
		assertThat(extracter.getMonth(), Is.is(11));
		assertThat(extracter.getYear(), Is.is(2012));
	}
	
	@Test
	public void shouldStringDateFromString() {
		DateExtracter extracter = new DateExtracter("14-3-2012");
		
		assertThat(extracter.getDate(), Is.is("14-3-2012"));
	}
	
	@Test
	public void shouldStringDateFromDateParts() {
		DateExtracter extracter = new DateExtracter(14, 3, 2012);
		
		assertThat(extracter.getDate(), Is.is("14-3-2012"));
	}

}

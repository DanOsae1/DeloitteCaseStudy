package com.osae.casestudy.timetable.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import com.osae.casestudy.timetable.Timings;

public class TimingsTest {

	Timings timings;
	String testTimeException;
	int duration;
	String testtime;

	@Before
	public void SetUp() {
		timings = new Timings();
		testTimeException = "09:00";
		duration = 60;
		testtime = "09:00 AM";
	}

	@Test
	public void increaseTheTimeByOnehour() throws ParseException {
		String time = timings.getTime(duration, testtime);
		assertEquals("10:00 AM", time);
	}

	@Test
	public void getDefaultTimeFromTimings() {
		assertNull(timings.getCurrentTime());
	}
	

}

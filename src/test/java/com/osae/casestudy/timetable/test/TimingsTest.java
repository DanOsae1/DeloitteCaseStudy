package com.osae.casestudy.timetable.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import com.osae.casestudy.timetable.Timings;

public class TimingsTest {

	Timings timings;
	String testTimeException;
	int duration;
	String testtime;
	SimpleDateFormat sdf;

	@Before
	public void SetUp() {
		timings = new Timings();
		testTimeException = "09:00";
		duration = 60;
		testtime = "09:00 AM";
		sdf = new SimpleDateFormat("HH:MM");
	}

	@Test
	public void increaseTheTimeByOnehour() throws ParseException {
		String time = timings.getTime(duration, testtime);
		assertEquals(sdf.parse("10:00 AM"), sdf.parse(time));
	}

	@Test
	public void getDefaultTimeFromTimings() {
		assertNull(timings.getCurrentTime());
	}
	

}

package com.osae.casestudy.activity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.osae.casestudy.activity.Event;

public class EventTest {
	String eventTitle;
	int duration;
	Event event;

	@Before
	public void Setup() {
		duration = 60;
		eventTitle = "The event test 60min";
		event = new Event(duration, eventTitle);
	}

	@Test
	public void createAnEventObject() {
		event = new Event(duration, eventTitle);
		assertNotNull(event);
	}

	@Test
	public void checkThatAnEventHasADuration() {
		assertEquals(event.getDuration(), duration);
	}
	
	@Test
	public void checkEventTitle() {
		assertEquals(event.getEventTitle(), eventTitle);
	}
	

}

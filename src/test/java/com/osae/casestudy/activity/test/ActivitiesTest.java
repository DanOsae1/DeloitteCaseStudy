package com.osae.casestudy.activity.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.osae.casestudy.activity.Activities;
import com.osae.casestudy.activity.Event;

public class ActivitiesTest {

	Activities activities;
	List<Event> testMap;

	@Before
	public void setup() {
		activities = new Activities();
		testMap = new ArrayList<Event>();

	}

	@Test
	public void checkThatTheActivitiesListIsPopulated() throws IOException {
		assertEquals(false, activities.getActivitesList().isEmpty());
	}

	@Test
	public void checkThatSprintsAreTranslatedTo15Mins() throws IOException {
		Iterator<Event> it = activities.getActivitesList().iterator();
		while (it.hasNext()) {
			Event event = it.next();
			if (event.getEventTitle().contains("sprint")) {
				assertEquals(15, event.getDuration());
			}
		}
	}

}

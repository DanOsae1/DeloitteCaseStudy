package com.osae.casestudy.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Activities {

	private static String filePath = "/activities.txt";

	public List<Event> getActivitesList() throws IOException {
		return getActivitiesList(filePath);
	}

	private List<Event> getActivitiesList(String filePath) throws IOException {
		List<Event> activitiesList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filePath)));
		Event event;
		String activities;
		while ((activities = reader.readLine()) != null) {
			if (activities.contains("sprint")) {
				event = new Event(15, activities);
				activitiesList.add(event);
			} else {
				String[] key = activities.split(" ");
				for (int i = 0; i < key.length; i++) {
					if (key[i].matches("([0-9])\\d+(min)")) {
						int mins = Integer.parseInt((String) key[i].subSequence(0, 2));
						event = new Event(mins, activities);
						activitiesList.add(event);
					}
				}

			}

		}
		return activitiesList;

	}

}
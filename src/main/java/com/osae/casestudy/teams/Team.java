package com.osae.casestudy.teams;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Team {

	private String name;
	private Map<String, String> schedule;

	public Team(String name, Map<String, String> schdedule) {
		this.name = name;
		this.schedule = schdedule;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getSchedule() {
		return schedule;
	}

	public String TimetableToString() {
		StringBuffer sb = new StringBuffer();
		sb.append(name + "\n");
		SortedSet<String> keys = new TreeSet<>(getSchedule().keySet());
		for (String time : keys) {
			String eventTitle = getSchedule().get(time);
			sb.append(time + " : " + eventTitle + "\n");
		}
		return sb.toString();
	}

}

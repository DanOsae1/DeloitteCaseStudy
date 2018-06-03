package com.osae.casestudy.teams;

import java.util.Map;

public class Team {

	private String name;
	private Map<String, String> schedule;

	public Team(String name, Map<String,String> schdedule) {
		this.name = name;
		this.schedule = schdedule;
	}

	public String getName() {
		return name;
	}

	public Map<String,String> getSchedule() {
		return schedule;
	}

	
	
}

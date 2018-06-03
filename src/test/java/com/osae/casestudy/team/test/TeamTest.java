package com.osae.casestudy.team.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.osae.casestudy.teams.Team;

public class TeamTest {
	Team team;
	String name;
	Map<String, String> schedule;
	String time;
	String event;

	@Before
	public void SetUp() {
		name = "TeamTest";
		time = "00:00";
		event = "test";
		schedule = new HashMap<>();
		schedule.put(time, event);
		team = new Team(name, schedule);
	}

	@Test
	public void testThatATeamHasAnEvent() {
		
		assertEquals((name + "\n" + time + " : " + event + "\n"), team.TimetableToString());
	}

	@Test
	public void getTeamName() {
		assertEquals(name, team.getName());
	}
	
	@Test
	public void getScheduleForTeam() {
		assertEquals(schedule, team.getSchedule());
	}

}

package com.osae.casestudy.timetable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.osae.casestudy.activity.Event;
import com.osae.casestudy.teams.Team;

public class Timetable {

	private static final String startTime = "08:00 AM";
	private static final int ComplusoryEventDuration = 60;
	private Timings timings = new Timings();
	private Team[] teams;
	private List<Event> activitiesList;

	public Timetable(List<Event> activites, int NumberOfTeams) {
		this.activitiesList = activites;
		this.teams = new Team[NumberOfTeams];
	}



    public Team[] getTeamTimetable() {
		return this.teams;
	}

	public void populateTimetable() throws Exception {

		timings.getTime(0, startTime);
		Iterator<Event> it = activitiesList.iterator();

		for (int i = 0; i < teams.length; i++) {
			int teamNo = i + 1;
			teams[i] = new Team(("Team " + teamNo + " : "), new HashMap<String, String>());

			while (it.hasNext() && timings.isLunch()) {
				Event event = it.next();
				teams[i].getSchedule().put(timings.getTime(event.getDuration(), timings.getCurrentTime()),
						event.getEventTitle());
			}
			teams[i].getSchedule().put(timings.getTime(ComplusoryEventDuration, timings.getCurrentTime()),
					"Lunch 60min");

			while (it.hasNext() && timings.isFinished()) {
				Event event = it.next();
				teams[i].getSchedule().put(timings.getTime(event.getDuration(), timings.getCurrentTime()),
						event.getEventTitle());
			}
			teams[i].getSchedule().put(timings.getTime(ComplusoryEventDuration, timings.getCurrentTime()),
					"Staff Motivation Presentation 60min");

			timings.getTime(0, startTime);
		}
	}

}

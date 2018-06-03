package com.osae.casestudy.timetable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import com.osae.casestudy.activity.Activities;
import com.osae.casestudy.activity.Event;
import com.osae.casestudy.teams.Team;

public class Timetable {

	private PrintWriter out;
	private static final String startTime = "08:00 AM";
	private Timings timings = new Timings();
	private Activities activities = new Activities();

	private Team team1 = new Team("Team1", Collections.emptyMap());

	private Team team2 = new Team("Team2", Collections.emptyMap());

	public void printFinalisedTimetable() throws Exception {
		out = new PrintWriter(new FileOutputStream(getTimetableFile()), true);
		List<Event> activitiesList = activities.getActivitesList();
		timings.getTime(0, startTime);

		out.println("Team1: \n");

		for (Event event : activitiesList) {
			printEvent(event);
			// change event from string to object

		}
		System.out.print("log.info(\"done\")");

	}

	private void schduleEvent(Event event) throws ParseException {

		team1.getSchedule().put(timings.getTime(event.getDuration(), timings.getCurrentTime()), event.getEventTitle());

		team2.getSchedule().put(timings.getTime(event.getDuration(), timings.getCurrentTime()), event.getEventTitle());

		// fill the time table for team 1 first when the time is past 5 o clock fill in
		// the timetable for team 2.
		// if the time is past 4 add the staff presentation
		// check if it is lunch time and check if lunch time is has already been
		// implemented in to the timetable

	}

	private void printEvent(Event event) throws ParseException {
		
		if (timings.getCurrentTime().contains("15:55 pm")) {
			out.println(timings.getTime(60, timings.getCurrentTime()) + " : " + "Staff Motivation Presentation");
			timings.getTime(0, "08:00 am");
			out.println("Team2: \n");
			out.println(timings.getTime(event.getDuration(), timings.getCurrentTime()) + " : " + event.getEventTitle());

		} else if (timings.getCurrentTime().contains("11:55 am")) {
			out.println(timings.getTime(60, timings.getCurrentTime()) + " : " + "Lunch");
			out.println(timings.getTime(event.getDuration(), timings.getCurrentTime()) + " : " + event.getEventTitle());

		} else {
			out.println(timings.getTime(event.getDuration(), timings.getCurrentTime()) + " : " + event.getEventTitle());
		}
	}

	private File getTimetableFile() throws IOException {
		File file = new File("src/main/resource/timetable.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	public static void main(String[] args) throws Exception {
		Timetable timetable = new Timetable();
		timetable.printFinalisedTimetable();
	}

}

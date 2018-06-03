package com.osae.casestudy.activity;

public class Event {

	private int duration;
	private String eventTitle;

	public Event(int mins, String eventTitle) {
		this.duration = mins;
		this.eventTitle = eventTitle;
	}

	public int getDuration() {
		return duration;
	}

	public String getEventTitle() {
		return eventTitle;
	}

}

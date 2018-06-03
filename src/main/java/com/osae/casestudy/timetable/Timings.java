package com.osae.casestudy.timetable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timings {

	private String time;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm a");

	public String getTime(int duration, String currentTime) throws ParseException {
		Date date = simpleDateFormat.parse(currentTime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, duration);
		String newTime = simpleDateFormat.format(cal.getTime());
		time = newTime;
		return newTime;
	}

	public String getCurrentTime() {
		return time;
	}
	
	public boolean isLunch() throws ParseException{
		return this.lunchtime();
	}
	
	public boolean isFinished() throws ParseException{
		return this.isEndOfDay();
	}

	private boolean lunchtime() throws ParseException {
		boolean lunchFlag = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		Date current = simpleDateFormat.parse(time);
		Date lunchStart = simpleDateFormat.parse("11:45");
		if (current.before(lunchStart)) {
			lunchFlag = true;
			return lunchFlag;
		}
		return lunchFlag;
	}

	private boolean isEndOfDay() throws ParseException {
		boolean finished = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		Date current = simpleDateFormat.parse(time);
		Date finshed = simpleDateFormat.parse("15:45 pm");

		if (current.before(finshed)) {
			finished = true;
			return finished;
		}
		return finished;
	}


}

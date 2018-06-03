package com.osae.casestudy.timetable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timings{

	private String time;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm a");
	private boolean lunchFlag = false;
	private boolean finished = false;

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

	public boolean isLunch() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		
		Date current = simpleDateFormat.parse(time);
		Date lunchStart = simpleDateFormat.parse("11:55 am");
		Date lunchEnd = simpleDateFormat.parse("12:55 pm");
		
		
		if(current.equals(lunchStart) && current.before(lunchEnd)) {
			lunchFlag = true;
			return lunchFlag;
		}
		return lunchFlag;

	}

	public boolean isFinished() throws ParseException {
		Date current = simpleDateFormat.parse(time);
		Date finshed = simpleDateFormat.parse("16:55 pm");
		Date fin = simpleDateFormat.parse("17:55 pm");
		if(current.after(finshed) && current.before(fin)) {
			finished = true;
			return finished;
		}
		return finished;
	}
	
	
}

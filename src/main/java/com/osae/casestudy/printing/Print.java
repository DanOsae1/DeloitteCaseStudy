package com.osae.casestudy.printing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.osae.casestudy.timetable.Timetable;

public class Print {

	private PrintWriter out;
	private Timetable timetable;
	private static final String timetableFilePath = "src/main/resource/timetable.txt";

	public Print(Timetable timetable) throws IOException {
		this.timetable = timetable;
		this.out = new PrintWriter(new FileOutputStream(getTimetableFile()), true);
	}

	public void print() {
		for (int i = 0; i < timetable.getTeamTimetable().length; i++) {
			out.println(timetable.getTeamTimetable()[i].TimetableToString());
		}
	}

	public File getTimetableFile() throws IOException {
		return this.getTFile();
	}

	private File getTFile() throws IOException {
		File file = new File(timetableFilePath);
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}
}

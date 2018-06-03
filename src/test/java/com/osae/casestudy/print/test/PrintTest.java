package com.osae.casestudy.print.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.osae.casestudy.printing.Print;
import com.osae.casestudy.timetable.Timetable;

public class PrintTest {

	Print print;
	Timetable timeable;

	@Before
	public void SetUp() throws IOException {

		print = new Print(timeable);
	}

	@Test
	public void checkIfWriteFileExisits() throws IOException {
		assertNotNull(print.getTimetableFile());
	}
}

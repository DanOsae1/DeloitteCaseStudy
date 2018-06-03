package com.osae.casestudy.Deloitte_Digital_Away_Day;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.osae.casestudy.activity.test.ActivitiesTest;
import com.osae.casestudy.activity.test.EventTest;
import com.osae.casestudy.print.test.PrintTest;
import com.osae.casestudy.team.test.TeamTest;
import com.osae.casestudy.timetable.Timetable;

import junit.framework.TestCase;

@RunWith(Suite.class)
@SuiteClasses({ PrintTest.class, TeamTest.class, ActivitiesTest.class, EventTest.class, Timetable.class })
public class AppTest extends TestCase {

}

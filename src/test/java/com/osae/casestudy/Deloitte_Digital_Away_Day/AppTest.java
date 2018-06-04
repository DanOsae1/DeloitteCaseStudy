package com.osae.casestudy.Deloitte_Digital_Away_Day;

import com.osae.casestudy.RWManager.test.RWManagerTest;
import com.osae.casestudy.fileManager.RWManager;
import com.osae.casestudy.timetable.test.TimetableTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.osae.casestudy.activity.test.ActivitiesTest;
import com.osae.casestudy.activity.test.EventTest;
import com.osae.casestudy.print.test.PrintTest;
import com.osae.casestudy.team.test.TeamTest;

import junit.framework.TestCase;

@RunWith(Suite.class)
@SuiteClasses({PrintTest.class, RWManagerTest.class, TeamTest.class, ActivitiesTest.class, EventTest.class, TimetableTests.class})
public class AppTest extends TestCase {

}

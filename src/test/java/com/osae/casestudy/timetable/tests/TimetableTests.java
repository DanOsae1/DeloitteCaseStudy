package com.osae.casestudy.timetable.test;

import com.osae.casestudy.activity.Event;
import com.osae.casestudy.teams.Team;
import com.osae.casestudy.timetable.Timetable;
import com.osae.casestudy.timetable.Timings;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TimetableTests {

    Timetable timetable;
    List<Event> testActivitesList;
    int numberOfTeams;
    Team[] testTeams;
    Event event;
    String scheduledEvent;
    Timings time;
    String startTime;

    @Before
    public void setup(){
        event = new Event(60,"test event");
        time = new Timings();
        startTime = "08:00 am";
        testActivitesList = new ArrayList<>();
        testActivitesList.add(event);
        numberOfTeams = 1;
        timetable = new Timetable(testActivitesList,numberOfTeams);
        testTeams = timetable.getTeamTimetable();
    }
    @Test
    public void testThatTheTimeTableisBeingPopulated() throws Exception {
        timetable.populateTimetable();
        for(int i = 0; i<testTeams.length;i++){
            scheduledEvent = testTeams[i].getSchedule().get(time.getTime(event.getDuration(),startTime));
        }

        assertEquals(event.getEventTitle(),scheduledEvent);
    }

}

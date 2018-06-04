package com.osae.casestudy.activity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.osae.casestudy.App;
import com.osae.casestudy.fileManager.RWManager;

public class Activities {


    private final static Logger log = Logger.getLogger(Activities.class.getName());

    public List<Event> getActivitesList() throws IOException {
        return getActivitiesList();
    }

    private List<Event> getActivitiesList() {
        try {
            List<Event> activitiesList = new ArrayList<>();
            log.info("Reading activities list file");
            BufferedReader reader = new BufferedReader(new InputStreamReader(RWManager.getActivitiesFile()));
            Event event;
            String activities;
            while ((activities = reader.readLine()) != null) {
                if (activities.contains("sprint")) {
                    event = new Event(15, activities);
                    activitiesList.add(event);
                } else {
                    String[] key = activities.split(" ");
                    for (int i = 0; i < key.length; i++) {
                        if (key[i].matches("([0-9])\\d+(min)")) {
                            int mins = Integer.parseInt((String) key[i].subSequence(0, 2));
                            event = new Event(mins, activities);
                            activitiesList.add(event);
                        }
                    }

                }

            }
            return activitiesList;
        } catch (IOException e) {
            log.severe(e.getCause().getMessage());
        }
        return Collections.emptyList();
    }
}

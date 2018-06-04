package com.osae.casestudy;

import java.util.Scanner;
import java.util.logging.Logger;

import com.osae.casestudy.activity.Activities;
import com.osae.casestudy.fileManager.RWManager;
import com.osae.casestudy.printing.Print;
import com.osae.casestudy.timetable.Timetable;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            log.info("Starting app");
            Scanner sc = new Scanner(System.in);
            System.out.println("** Welcome ");

            System.out.println(
                "** Currently have file: " + RWManager.filePath + " on record, Do you wish to proceed? (Y/N) ");
            String choice = sc.next();
            log.info("Waiting for user interaction");
            if (!choice.equalsIgnoreCase("y")) {
                RWManager.confirmPath(sc);
            }

            System.out.println("** How many teams will be participating ? (Default is 2)");
            String teamnumber = sc.next();
            int tNumber;
            if (teamnumber.matches("-?\\d+")) {
                tNumber = Integer.parseInt(teamnumber);
            } else {
                tNumber = 2;
            }
            sc.close();

            System.out.println("** Populating timetables");
            log.info("Initializing app");
            Activities activities = new Activities();
            Timetable timetable = new Timetable(activities.getActivitesList(), tNumber);

            timetable.populateTimetable();
            log.info("Timetable population complete");

            System.out.println("** Printing timetables");
            Print print = new Print(timetable);

            print.print();

            System.out.println("Complete .. " + print.getTimetableFile().getAbsolutePath());

        } catch (Exception e) {
            log.severe("An error occured " + e.getMessage());
        }
    }
}

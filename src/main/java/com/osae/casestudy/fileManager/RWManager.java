package com.osae.casestudy.fileManager;


import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;


/**
 * Created by 44102628 on 04/06/2018.
 */
public class RWManager {

    private final static Logger log = Logger.getLogger(RWManager.class.getName());
    private static String inputFilePath;
    public static String filePath = "/activities.txt";
    public static boolean fileExist;
    private static File inputFile;


    public static InputStream getActivitiesFile() throws IOException {
        return getInputFile();
    }

    public static void confirmPath(Scanner sc) {
        System.out.println("Enter the file path or type N(to Cancel)");
        String ScannerInput = sc.next();
        if (!ScannerInput.equalsIgnoreCase("n")) {
            String path = ScannerInput;
            inputFile = new File(path);
            if (!inputFile.exists()) {
                log.warning("cannot find file");
            } else {
                log.info("Found file, setting path");
                inputFilePath = ScannerInput;
                fileExist = true;
            }
        } else {
            System.exit(1);
        }
    }


    private static InputStream getInputFile() throws IOException {
        if (fileExist) {
            InputStream is;
            return is = new FileInputStream(inputFile);
        }
        return RWManager.class.getResourceAsStream(filePath);
    }


}

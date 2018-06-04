package com.osae.casestudy.RWManager.test;

import com.osae.casestudy.fileManager.RWManager;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by 44102628 on 04/06/2018.
 */
public class RWManagerTest {

    String testFileInputPath;
    InputStream inputStream;
    Scanner scanner;

    @Before
    public void setUp() {

        testFileInputPath = "foo/bar.txt";
        inputStream = new ByteArrayInputStream(testFileInputPath.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
    }

    @Test
    public void confirmFileCannotBeFound()throws Exception {
      assertEquals(false,RWManager.fileExist);
    }


}

package com.epam.java.se.hw1;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppTest {

    private  App app;


    @Before
    public void init(){
        app = new App();
    }


    @Ignore
    @Test
    public void testThatMethodGoToWorksRight(){
        assertTrue(app.contains("unit1"));
        app.goTo("unit5");
        assertTrue(app.contains("src"));
        app.goTo("unit5\\main\\java");
        assertTrue(app.contains("com"));
        app.goTo("..");
        assertTrue(app.contains("unit1"));
    }

    @Ignore
    @Test(expected = FileNotFoundException.class)
    public void testThatAppCantDeleteNonExistingFile(){
        app.remove("customDir");
    }

    @Ignore
    @Test(expected = FileAlreadyExistsException.class)
    public void testThatAppCantCreateAnExitingFile(){
        app.createDir("customDir");
        app.createDir("customDir");
    }

    @Ignore
    @Test
    public void testThatMethodContainsWorksRight(){
        app.createDir("customDir");
        app.createFile("customFile");
        assertTrue(app.contains("customDir"));
        assertTrue(app.contains("customFile"));
    }

    @Ignore
    @Test
    public void testThatMethodDeleteWorksRight(){
        app.createDir("customDir");
        assertTrue(app.contains("customDir"));
        app.remove("customDir");
        assertFalse(app.contains("customDir"));
    }

    @Ignore
    @Test
    public void testThatMethodWriteToFileWorksRight(){
        app.writeToFile("unit5\\src\\main\\resources\\customFile.txt", "Hello, World!");
        String testFromFile = app.readFromFile("unit5\\src\\main\\resources\\customFile.txt");
        String benchmark = "Hello, Word!";
        assertEquals(benchmark, testFromFile);
    }

}
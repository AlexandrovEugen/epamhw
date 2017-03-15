package com.epam.java.se.hw1;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppTest {

    List<String> catCommand;

    @Before
    public void init(){
        String command = "cat >> file.txt Hello, world!";
         catCommand = Arrays.asList(command.split(" "));
    }

    @Ignore
    @Test
    public void changeCurrentDirectoryTest(){
        App.changeCurrentDirectory("unit1");
        assertTrue(App.contains("src"));
        App.changeCurrentDirectory("..");
        assertTrue(App.contains("unit1"));
    }

    @Ignore
    @Test
    public void deleteDirTest()  {
        App.createDir("tmp");
        assertTrue(App.contains("tmp"));
        App.deleteDir("tmp");
        assertFalse(App.contains("tmp"));
    }

    @Ignore
    @Test
    public void readFromFileTest() {
        App.createFile("file.txt");
        App.rewriteFile(catCommand);
        String[] test = (String[]) App.readFromFile(catCommand).toArray();
        String[] benchmark = (String[]) catCommand.stream().skip(3).collect(Collectors.toList()).toArray();
        for (String aTest : benchmark) {
            System.out.println(aTest);
        }
    }

    @Ignore
    @Test
    public void deleteFileTest() {
        App.createFile("tmp.txt");
        assertTrue(App.contains("tmp.txt"));
        App.deleteFile("tmp.txt");
        assertFalse(App.contains("tmp.txt"));
    }

}
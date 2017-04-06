package com.epam.java.se.hw1;


import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@FixMethodOrder
public class AppTest {

    @Test
    public void readFromFileTest() {
        String writeCommand = "cat >> fileForReading.txt Hello, world!";
        List<String> catCommand = Arrays.asList(writeCommand.split(" "));
        App.createFile("fileForReading.txt");
        App.cat(catCommand);
        String ReadCommand = "cat fileForReading.txt";
        List<String> commandList = Arrays.asList(ReadCommand.split(" "));
        List<String> cat = App.cat(commandList);
        assertTrue(cat != null);
        assertTrue(cat.size() == 2);
        assertThat(cat.get(0), is(equalTo(catCommand.get(3))));
        assertThat(cat.get(1), is(equalTo(catCommand.get(4))));
        App.deleteDir("fileForReading.txt");
    }

    @Test
    public void changeCurrentDirectoryTest(){
        App.changeCurrentDirectory("unit1");
        assertTrue(App.contains("src"));
        App.changeCurrentDirectory("..");
        assertTrue(App.contains("unit1"));
    }



    @Test
    public void deleteDirTest()  {
        App.createDir("tmp1");
        assertTrue(App.contains("tmp1"));
        App.deleteDir("tmp1");
        assertFalse(App.contains("tmp1"));
    }

    @Test
    public void deleteFileTest() {
        App.createFile("tmp.txt");
        assertTrue(App.contains("tmp.txt"));
        App.deleteFile("tmp.txt");
        assertFalse(App.contains("tmp.txt"));
    }

}
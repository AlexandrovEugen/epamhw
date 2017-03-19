package com.epam.java.se.hw2;


import org.junit.Before;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class UniversalPropertyReaderTest {


    private ResourceBundle resourceBundle;

    @Before
    public void readWithoutThreads(){
        Locale locale = new Locale("en");
        resourceBundle = ResourceBundle.getBundle("fileforhw2", locale);
    }



    @Test
    public void testThatFilesKeysWereWrittenInMultiThreadMode(){
        UniversalPropertyReader reader = new UniversalPropertyReader();
        reader.read("fileforhw2");

        Set<Long> longVal = reader.readValForLong();
        Set<Integer> intVal =  reader.readValForInt();
        Set<Double>  doubleVal = reader.readValForDouble();
        Set<String>  stringVal = reader.readValForString();

        longVal.forEach(l -> stringVal.add(String.valueOf(l)));
        intVal.forEach(i -> stringVal.add(String.valueOf(i)));
        doubleVal.forEach(d -> stringVal.add(String.valueOf(d)));

        for (String key : resourceBundle.keySet()) {
            assertTrue(stringVal.contains(resourceBundle.getString(key)));
        }
    }
}
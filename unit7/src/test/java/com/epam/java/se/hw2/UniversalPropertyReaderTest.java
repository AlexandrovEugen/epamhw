package com.epam.java.se.hw2;


import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

public class UniversalPropertyReaderTest {


    private ResourceBundle resourceBundle;

    @Before
    public void readWithoutThreads(){
        resourceBundle = ResourceBundle.getBundle("epamhw\\unit7\\src\\main\\resources\\fileforhw2.properties");
    }



    @Test
    public void testThatFilesKeysWereWrittenInMultiThreadMode(){
        UniversalPropertyReader reader = new UniversalPropertyReader();

        Set<Long> longKeys = reader.readKeysForLong();
        Set<Integer> intKeys =  reader.readKeysForInt();
        Set<Double>  doubleKeys = reader.readKeysForDouble();
        Set<String>  stringKeys = reader.readKeysForString();

        longKeys.forEach(l -> stringKeys.add(String.valueOf(l)));
        intKeys.forEach(i -> stringKeys.add(String.valueOf(i)));
        doubleKeys.forEach(d -> stringKeys.add(String.valueOf(d)));

        for (String keys :stringKeys) {
            assertTrue(resourceBundle.containsKey(keys));
        }
    }
}
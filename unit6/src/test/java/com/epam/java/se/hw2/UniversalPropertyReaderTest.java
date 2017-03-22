package com.epam.java.se.hw2;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class UniversalPropertyReaderTest {

    private Locale locale;
    private ResourceBundle resource;
    private UniversalPropertyReader uReader;

    @Before
    public void init(){
        locale = new Locale("en");
        resource = ResourceBundle.getBundle("propertyfile", locale);
        uReader = new UniversalPropertyReader();
    }

    @Test
    public void testThatCanInitiate(){
        UniversalPropertyReader uReader = new UniversalPropertyReader();
        assertThat(uReader, is(notNullValue()));
    }

    @Test(expected = MissingResourceException.class)
    public void testThatThrowsExceptionWithNonExistingFile(){
        uReader.load("notExists");
    }

    @Test
    public void testThatAllKeysFroPropertyFileAreContainInMap(){
        Set<String> keysFromReader = uReader.getKeys();
        Set<String> resourceKeys = resource.keySet();
        for (String key: resourceKeys){
            assertThat(key, is(keysFromReader.contains(key)));
        }
    }

    @Test
    public void testThatAllValuesFromPropertyFileAreContainInMap(){
        Set<String> valFromReader = uReader.getValues();
        Set<String> resourceKeys = resource.keySet();
        for (String key: resourceKeys){
            assertThat(resource.getString(key), is((valFromReader.contains(resource.getString(key)))));
        }
    }
}
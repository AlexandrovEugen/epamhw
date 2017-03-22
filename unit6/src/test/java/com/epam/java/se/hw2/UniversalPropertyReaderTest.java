package com.epam.java.se.hw2;


import org.junit.Before;
import org.junit.Test;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
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
        uReader.load("propertyfile");
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
        final Set<String> keysFromReader = uReader.getKeys();
        final Set<String> resourceKeys = resource.keySet();
        for (String key: resourceKeys){
            assertTrue(keysFromReader.contains(key));
        }
    }

    @Test
    public void testThatAllValuesFromPropertyFileAreContainInMap(){
        final Set<String> valFromReader = uReader.getValues();
        final Set<String> resourceKeys = resource.keySet();
        for (String key: resourceKeys){
          assertTrue(valFromReader.contains(resource.getString(key)));
        }
    }

}
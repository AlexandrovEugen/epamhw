package com.epam.java.se.hw2;


import org.junit.Before;
import org.junit.Test;


import java.util.Locale;
import java.util.ResourceBundle;

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

    @Test
    public void testThatThrowsExceptionWithNonExistingFile(){}

    @Test
    public void testThatAllKeysFroPropertyFileAreContainInMap(){
    }

    @Test
    public void testThatAllValuesFromPropertyFileAreContainInMap(){}
}
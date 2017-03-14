package com.epam.java.se.hw2.classes;


import com.epam.java.se.hw2.exeptions.NoSuchKeyFromPropertyFile;
import com.epam.java.se.hw2.exeptions.PropertiesFileNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class PropertyLoaderTest {

    private PropertyLoader pl;

    @Before
    public void init(){
        pl = new PropertyLoader();
        pl.load("default.properties");
    }

    @Test
    public void testThatWeCanGetByExistingKey(){
        final ResourceBundle defaultBundle = pl.getDefaultBundle();
        assertEquals("defaultValue1",defaultBundle.getString("key1"));
    }

    @Test(expected = PropertiesFileNotFoundException.class)
    public void testThatWeWillHaveFailedWhenWeTryLoadNonExistingPropertyFile(){
        pl.load("nonExisting.properties");
    }

    @Test(expected = NoSuchKeyFromPropertyFile.class)
    public void testThatWeWillHaveFailedWhenWeTryGetNonExistingKeyFromProperties(){
        final ResourceBundle defaultBundle = pl.getDefaultBundle();
        defaultBundle.getString("key15");
    }
}
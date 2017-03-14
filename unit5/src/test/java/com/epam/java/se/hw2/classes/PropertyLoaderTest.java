package com.epam.java.se.hw2.classes;


import com.epam.java.se.hw2.exeptions.NoSuchKeyFromPropertyFile;
import com.epam.java.se.hw2.exeptions.PropertiesFileNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertyLoaderTest {

    private PropertyLoader pl;

    @Before
    public void init(){
        pl = new PropertyLoader();
        try {
            pl.load("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit5\\src\\main\\resources\\default.properties");
        } catch (PropertiesFileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThatWeCanGetValueByExistingKey(){
        final PropertyLoader defaultBundle = pl.getDefaultBundle();
        assertEquals("defaultValue1",defaultBundle.getString("key1"));
    }


    @Test(expected = PropertiesFileNotFoundException.class)
    public void testThatWeWillHaveFailedWhenWeTryLoadNonExistingPropertyFile() throws PropertiesFileNotFoundException {
        pl.load("nonExisting.properties");
    }

    @Test(expected = NoSuchKeyFromPropertyFile.class)
    public void testThatWeWillHaveFailedWhenWeTryGetNonExistingKeyFromProperties(){
        final PropertyLoader defaultBundle = pl.getDefaultBundle();
        defaultBundle.getString("key15");
    }
}
package com.epam.java.se.hw2;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class UniversalPropertyReader {


    public void load(String propertyfile) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyfile, new Locale("en"));

    }

    public Set<String> getKeys() {
        return null;
    }

    public Set<String> getValues(){
        return null;
    }
}

package com.epam.java.se.hw2;


import java.util.Locale;
import java.util.ResourceBundle;

public class UniversalPropertyReader {


    public void load(String propertyfile) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyfile, new Locale("en"));

    }
}

package com.epam.java.se.hw2.exeptions;

import java.io.FileNotFoundException;


public class PropertiesFileNotFoundException extends FileNotFoundException {

    public PropertiesFileNotFoundException() {
        super();
    }

    public PropertiesFileNotFoundException(String s) {
        super(s);
    }

    PropertiesFileNotFoundException(String path, String reason){
        super(path + ((reason == null)
                ? ""
                : " (" + reason + ")"));
    }
}

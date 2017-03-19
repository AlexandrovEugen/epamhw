package com.epam.java.se.hw2;


import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReadProperty extends Thread {


    private ResourceBundle resourceBundle;

    public ReadProperty(String fileName) throws FileNotFoundException, NoSuchFileException {
        Objects.requireNonNull(fileName);

        ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
    }


    @Override
    public void run() {
    }

}

package com.epam.java.se.hw1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFile {


    private final String simpleName;
    private Dir location;
    private StringBuilder fullName = new StringBuilder();

    public TextFile(String simpleName) {
        this.simpleName = simpleName;
    }

    public void createFile(Dir location){
        this.location = location;
        fullName.append(location.getFullName()).append("\\").append(simpleName).append(".txt");
        Path path = Paths.get(getFullName());
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        location.getFiles().add(this);
    }

    public String getSimpleName() {
        return simpleName;
    }

    public Dir getLocation() {
        return location;
    }

    public String getFullName() {
        return fullName.toString();
    }
}

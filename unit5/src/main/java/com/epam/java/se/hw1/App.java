package com.epam.java.se.hw1;


import com.epam.java.se.hw1.handlers.Reader;
import com.epam.java.se.hw1.handlers.Writer;

import java.util.Set;

public class App {


    private final Dir root;
    private final Set<Dir> dirs;
    private final Set<TextFile> files;

    public App() {
       root =  new Dir("root");
       root.createDir(null);
       dirs = root.getChildren();
       files = root.getFiles();
    }


    public boolean contains(String simpleName) {
        return true;
    }

    public void goTo(String dirName) {

    }

    public void remove(String name) {

    }

    public void createDir(String dirName) {
    }

    public void createFile(String fileName) {
    }

    public void writeToFile(String fileName, String message) {
        new Writer().writeToFile(fileName, message);
    }

    public String readFromFile(String fileName) {
        return new Reader().read(fileName);
    }
}

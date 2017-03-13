package com.epam.java.se.hw1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dir {

    Logger log = Logger.getLogger(Dir.class.getName());
    private final String simpleName;
    private final StringBuilder fullName = new StringBuilder();
    private final Set<Dir> children = new HashSet<>();
    private final Set<TextFile> files = new HashSet<>();
    private final String DEFAULT_PATH = "C:\\Users\\Евгений\\IdeaProjects\\epamhw";
    private Dir parent;

    public Dir(String simpleName) {
        this.simpleName = simpleName;
        fullName.append(DEFAULT_PATH);
    }

    public void createDir(Dir parent) {
        this.parent = parent;
        Path path;
        if (parent != null){
            fullName.append(parent.getFullName()).append("\\").append(simpleName);
            path = Paths.get(this.getFullName());
            parent.getChildren().add(this);
        }
        else {
            fullName.append("\\").append(simpleName);
            path = Paths.get(this.getFullName());
        }
        try {
            Files.createDirectory(path);
            log.log(Level.INFO, "The directory:" + simpleName + "was created successfully");
        } catch (IOException e){
            log.log(Level.WARNING, "File with this name is already exists in this directory");
        }
    }

    public String getFullName(){
        return fullName.toString();
    }

    public Set<Dir> getChildren(){
        return children;
    }

    public Set<TextFile> getFiles(){
        return files;
    }

    public String getSimpleName(){
        return simpleName;
    }

    public Dir getParent(){
        return parent;
    }
}

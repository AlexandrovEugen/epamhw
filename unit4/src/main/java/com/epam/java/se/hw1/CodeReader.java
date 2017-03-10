package com.epam.java.se.hw1;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class CodeReader {

    private final String javaFile;
    public StringBuilder getBitesToString() {
        return bitesToString;
    }

    private final StringBuilder bitesToString = new StringBuilder();

    public CodeReader(String testFile) {
        Objects.requireNonNull(testFile);
        String[] split = testFile.split("[.]");
        if (!split[split.length -1].equals("java")){
            throw new IllegalArgumentException();
        }
        this.javaFile = testFile;
    }

    public void read(){
        int b;
        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(javaFile))) {
            while ((b = input.read()) != -1){
                bitesToString.append((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

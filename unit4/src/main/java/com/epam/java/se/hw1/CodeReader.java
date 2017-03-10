package com.epam.java.se.hw1;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CodeReader {

    private final String javaFile;
    private final Map<String, Integer> keyWordsAndTheirAmount = new HashMap<>();
    private final ResourceBundle keyWordsFromProperties = ResourceBundle.getBundle("keyWords");


    public CodeReader(String testFile) {
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
                System.out.println("byte" +  b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

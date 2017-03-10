package com.epam.java.se.hw2;

import com.epam.java.se.hw1.CodeReader;

import java.io.*;

public class CharReader extends CodeReader {
    private String testFile;

    public StringBuilder getJavaCode() {
        return javaCode;
    }

    StringBuilder javaCode = new StringBuilder();

    public CharReader(String testFile) {
        super(testFile);
        this.testFile = testFile;
    }

    @Override
    public void read() {
        try(BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(testFile)))) {
            while (bis.ready()){
                javaCode.append(bis.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

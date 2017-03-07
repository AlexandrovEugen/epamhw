package com.epam.java.se.hw3;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinyParser {

    private String nameOfFile;
    private final StringBuilder input = new StringBuilder();
    private final StringBuilder output = new StringBuilder();
    private final Pattern refPattern = Pattern.compile("[Р|р]ис(\\.)?([унок|унки|унках|унком|])*");

    public TinyParser(String nameOfFile)
    {
        this.nameOfFile = nameOfFile;
    }

    public void load(){
        final String patternForSkip = "<br style=\"clear:both;\">";
        skipUselessPathOfFile(patternForSkip);
    }

    private void skipUselessPathOfFile(String mark) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfFile), "windows-1251"))) {
            boolean canSkip = true;
            while (reader.ready() && canSkip){
                Pattern pattern = Pattern.compile(mark);
                Matcher m = pattern.matcher(reader.readLine());
                if (m.matches()){
                    canSkip = false;
                }
            }
            while (reader.ready()){
                input.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findAndGetBold(){
        String[] split = input.toString().split("\n");
        Matcher m;
        for (String line: split) {
            m = refPattern.matcher(line);
            if (m.find()){
                output.append(bold(line)).append("\n");
            }
        }
    }



    public StringBuilder getInput() {
        return input;
    }

    public StringBuilder getOutput(){
        return output;
    }

    private String bold(String line){
        return "<b>" + line + "<b>";
    }
}
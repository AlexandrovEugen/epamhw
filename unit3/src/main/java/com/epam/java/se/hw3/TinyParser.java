package com.epam.java.se.hw3;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinyParser {

    private String nameOfFile;
    private final StringBuilder input = new StringBuilder();
    private final StringBuilder output = new StringBuilder();
    private final StringBuilder skippedPart = new StringBuilder();
    private final Pattern refPattern = Pattern.compile("[Р|р]ис(\\.)?([унок|унки|унках|унком|])*");

    public TinyParser(String nameOfFile)
    {
        this.nameOfFile = nameOfFile;
    }


    public void upload(){
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.html"), "windows-1251"))) {
            String[] skippedSplit = skippedPart.toString().split("\n");
            String[] outputSplit = output.toString().split("\n");
            for (String useless: skippedSplit) {
              writer.write(useless);
            }
            for (String line: outputSplit){
                writer.write(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
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
                String useless = reader.readLine();
                Matcher m = pattern.matcher(useless);
                skippedPart.append(useless).append("\n");
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
            else {
                output.append(line).append("\n");
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
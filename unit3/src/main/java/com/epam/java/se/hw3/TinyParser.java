package com.epam.java.se.hw3;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinyParser {

    private String nameOfFile;
    private final StringBuilder input = new StringBuilder();
    private final StringBuilder output = new StringBuilder();
    private final StringBuilder skippedPart = new StringBuilder();
    private final Pattern REFPATTERN = Pattern.compile("[Р|р]ис[.]?([унок|унки|унках|унком|])*");
    private final List<Integer> links = new ArrayList<>();

    private final Pattern SEQUENCE_PATTERN = Pattern.compile("[Р|р]ис([.])?([унок|унки|унках|унком|])*[\\s]([\\d]){1,2}");

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
        Matcher matcher;
        String[] lines = input.toString().split("\n");
        for (String line: lines) {
            String abbrevReplace = line.replaceAll("[(][Р|р]ис.", "abbrev");
            String dotsReplace = abbrevReplace.replaceAll("[.]", ".`");
            String[] sentences = dotsReplace.split("`");
            for (String sentence: sentences) {
                String originSentence = sentence.replaceAll("abbrev", "(Рис.");
                matcher = REFPATTERN.matcher(originSentence);
                if (matcher.find()){
                    Matcher m  = SEQUENCE_PATTERN.matcher(originSentence);
                    if (m.find()){
                        Pattern p = Pattern.compile("\\d+");
                        Matcher m1 = p.matcher(m.group());
                        if (m1.find()){
                            links.add(Integer.parseInt(m1.group()));
                        }
                        output.append(bold(originSentence));
                    }

                }
                else {
                    output.append(originSentence);
                }
            }
            this.output.append("\n");
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


    public boolean isConsistently() {
        boolean consistently = true;
        for (int i = 1; i < links.size(); i++) {
            if (links.get(i-1).compareTo(links.get(i)) != 1) {
                consistently = false;
            }
        }
        return consistently;
    }
}
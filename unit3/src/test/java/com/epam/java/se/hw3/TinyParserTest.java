package com.epam.java.se.hw3;


import org.junit.Ignore;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class TinyParserTest {

    @Ignore
    @Test
    public void testThatWeCanReadFile(){
        TinyParser tp = new TinyParser("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit3\\src\\main\\resources\\textforhw3.html");
        tp.load();
        String[] split = tp.getInput().toString().split("\n");
        for (String st: split) {
            System.out.println(st);
        }
    }

    @Ignore
    @Test
    public void testThatPatternCanFindKeyWord(){
        Pattern pattern = Pattern.compile("[Р|р]ис(\\.)?([унок|унки|унках|унком|])*");
        Matcher m = pattern.matcher( "рисунок");
        assertTrue(m.find());
    }

    @Ignore
    @Test
    public void testThatWeCanFindAndGetBoldNeededSentences(){
        TinyParser tp = new TinyParser("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit3\\src\\main\\resources\\textforhw3.html");
        tp.load();
        tp.findAndGetBold();
        String[] split = tp.getOutput().toString().split("\n");
        for (String st: split) {
            System.out.println(st);
        }
    }


    @Ignore
    @Test
    public void testUpload(){
        TinyParser tp = new TinyParser("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit3\\src\\main\\resources\\textforhw3.html");
        tp.load();
        tp.findAndGetBold();
        tp.upload();
    }
    @Ignore
    @Test
    public void testThatRegExpForFindingRefsWorksRight(){
        Pattern refPattern = Pattern.compile("[Р|р]ис(\\.)?([унок|унки|унках|унком|])*");

        String line1 = "<p>(Рис. 2), марковка, кочарыжка. Cкорлупа, зал. Попкорн, зал рисования, казино (рис. 6).<\\p>";
        String line2 = "<div>(Рис. 9), Картошка, Селёдка. Мука, Похлёбка. Загон, уроки рисования, казино рисунки.<\\div>";
        String line3 = "<snap>Поворёшка, Мартышка. Селёдка, бал. Кардон, зал любования, мороженое.<\\snap>";

        StringBuilder buildLines = new StringBuilder();
        StringBuilder outputLines = new StringBuilder();
        buildLines.append(line1).append("\n").append(line2).append("\n").append(line3).append("\n");

        String[] lines = buildLines.toString().split("\n");


        for (String line: lines){

            String abbrevReplaceLine = line.replaceAll("[(][Р|р]ис.", "abbrev");
            String dotReplaceLine = abbrevReplaceLine.replaceAll("[.]", ".`");
            String[] sentences = dotReplaceLine.split("`");

            Matcher m;
            for (String sentence: sentences) {
                String originSentence = sentence.replaceAll("abbrev", "(Рис.");
                m = refPattern.matcher(originSentence);
                if (m.find()){
                    outputLines.append("<b>").append(originSentence).append("<\\b>");
                }
                else {
                    outputLines.append(originSentence);
                }
            }
            outputLines.append("\n");
        }
        String[] theLines = outputLines.toString().split("\n");
        for (String line: theLines){
            System.out.println(line);
        }
    }
    @Test
    public void testThatRegExpForFindingTagsInTheStarAndEndOfLineWorksRight(){
        Pattern tagPatternStart = Pattern.compile("^<(.){1,4}>.*[^<>]$");
        Pattern tagPatternEnd = Pattern.compile("^[^<>].*<(.){1,4}>$");
        String start = "<p>(Рис. 2), марковка, кочарыжка.";
        String end = "Попкорн, зал рисования, казино (рис. 6).<\\p>";
        Matcher matchStart = tagPatternStart.matcher(start);
        Matcher matchEnd = tagPatternEnd.matcher(end);
        assertTrue(matchEnd.matches());
        assertTrue(matchStart.matches());
    }
}
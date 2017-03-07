package com.epam.java.se.hw3;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class TinyParserTest {

    @Test
    public void testThatWeCanReadFile(){
        TinyParser tp = new TinyParser("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit3\\src\\main\\resources\\textforhw3.html");
        tp.load();
        String[] split = tp.getStringBuilder().toString().split("\n");
        for (String st: split) {
            System.out.println(st);
        }
    }

    @Test
    public void testThat(){
        Pattern pattern = Pattern.compile("[Р|р]ис(\\.)?([унок|унки|унках|унком|])*");
        Matcher m = pattern.matcher("рис.");
        assertTrue(m.find());
    }
}
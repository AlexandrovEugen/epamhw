package com.epam.java.se.hw3;


import org.junit.Test;

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
}
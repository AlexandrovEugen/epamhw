package com.epam.java.se.hw1;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CodeWriterTest {

    @Test
    public void testThatWeCanFindAllKeyWords(){
        Map<String,Integer> benchMark = new HashMap<>();

        CodeReader reader = new CodeReader("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\BinarySearch.java");
        reader.read();
    }


}
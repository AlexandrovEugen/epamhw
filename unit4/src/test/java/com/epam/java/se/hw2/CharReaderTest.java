package com.epam.java.se.hw2;


import com.epam.java.se.hw1.CodeReader;
import com.epam.java.se.hw1.CodeWriter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CharReaderTest {

    @Test
    public void testThatWeCanFindAllKeyWordsAndTheirAmount(){

        Map<String,Integer> benchMark = new HashMap<>();
        benchMark.put("implements", 1);
        benchMark.put("new", 1);
        benchMark.put("private", 1);
        benchMark.put("package", 1);
        benchMark.put("import", 1);
        benchMark.put("for", 1);
        benchMark.put("int", 6);
        benchMark.put("public", 2);
        benchMark.put("extends",1);
        benchMark.put("throw",1);
        benchMark.put("else", 2);
        benchMark.put("class", 1);
        benchMark.put("if", 4);
        benchMark.put("return",5);

        CodeReader reader = new CharReader("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\BinarySearch.java");
        reader.read();
        CodeWriter writer = new CodeWriter(reader);
        Map<String, Integer> keyWords = writer.getKeyWords();

        for (String word: keyWords.keySet()){
            assertEquals(keyWords.get(word), benchMark.get(word));
        }
    }
}
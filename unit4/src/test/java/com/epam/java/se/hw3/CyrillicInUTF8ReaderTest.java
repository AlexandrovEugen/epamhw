package com.epam.java.se.hw3;


import org.junit.Test;

public class CyrillicInUTF8ReaderTest {


    @Test
    public void testThatWeCanReadTextInUTF8(){
        CyrillicInUTF8Reader reader = new CyrillicInUTF8Reader("src\\main\\resources\\Russian-Lipsum.txt");
        reader.utf8Read();
        CyrillicUTF16Writer writer = new CyrillicUTF16Writer(reader);
        writer.writeToFile();
    }

    @Test(expected = NullPointerException.class)
    public void testOnValidityOfInputArgumentsForReading(){
        CyrillicInUTF8Reader reader = new CyrillicInUTF8Reader(null);
    }


    @Test(expected = NullPointerException.class)
    public void testOnValidityOfInputArgumentsForWriting(){
        CyrillicUTF16Writer writer = new CyrillicUTF16Writer(null);
    }

}
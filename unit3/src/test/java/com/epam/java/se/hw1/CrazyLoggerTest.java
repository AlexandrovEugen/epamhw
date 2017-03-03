package com.epam.java.se.hw1;

import org.junit.Test;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;


public class CrazyLoggerTest {



    @Test
    public void testThatMethodFindInfoWorksRight(){
        CrazyLogger logger = new CrazyLogger(CrazyLoggerTest.class.getName());
        String msg = "";
        logger.log(msg);
    }

    @Test
    public void testThatMethodLogWorksRight(){

    }
}
package com.epam.java.se.hw1;

import org.junit.Test;



import static org.junit.Assert.*;


public class CrazyLoggerTest {

    @Test(expected = NullPointerException.class)
    public void testThatMethodLogWillHasFailedAtStart(){
        CrazyLogger log = new CrazyLogger(CrazyLoggerTest.class.getSimpleName());
        log.log(null);
    }

    @Test
    public void testThatLogForTryCatchBlockWillHasBeenWritten(){
        CrazyLogger logger = new CrazyLogger(CrazyLoggerTest.class.getSimpleName());
        try {
            String b = null;
            System.out.println(b.toString());
        }
        catch (NullPointerException e){
            logger.log("Something is going wrong", e);
        }
        assertFalse("This log doesn't exists".equals(logger.findByMsg("Something is going wrong")));
        System.out.println(logger.info());
    }
}

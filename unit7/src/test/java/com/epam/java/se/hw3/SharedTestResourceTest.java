package com.epam.java.se.hw3;


import org.junit.Test;

public class SharedTestResourceTest {


    @Test
    public void deadLockTest() throws InterruptedException {
        SharedResource res = new SharedResource();

        IntegerSetterGetter t0 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t1 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("4", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("5", res);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(100);

        t0.stopThread();
        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();

        t0.join();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("main");
    }

}

package com.epam.java.se.hw3;


import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedTestResourceTest {


    @Test
    public void deadLockTest() throws InterruptedException {
        SharedResource res = new SharedResource();

        IntegerSetterGetter t0 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t1 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("4", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("5", res);
        IntegerSetterGetter t5 = new IntegerSetterGetter("6", res);

        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(t0);
        ex.execute(t1);
        ex.execute(t2);
        ex.execute(t3);
        ex.execute(t4);
        ex.execute(t5);
        ex.shutdown();

        System.out.println("main");
    }

}

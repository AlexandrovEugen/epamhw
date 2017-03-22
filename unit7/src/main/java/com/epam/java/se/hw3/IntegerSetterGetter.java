package com.epam.java.se.hw3;


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerSetterGetter extends  Thread {

    private final SharedResource resource;
    private final Random rnd = new Random();
    private final Lock lock = new ReentrantLock();
    private boolean run;

    public IntegerSetterGetter(String name, SharedResource resource){
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread(){
        run = false;
    }

    @Override
    public void run() {

        boolean action;

        try {
            while (run){
                action = rnd.nextBoolean();
                if (action){
                    getIntegerFromResource();
                }
                else {
                    setIntegerFromResource();
                }
            }
            System.out.println("Поток" + getName() + " завершил работу.");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void getIntegerFromResource() throws InterruptedException {
        Integer number;
        synchronized (resource) {
            System.out.println("Поток " + getName() + " ждёт пока очередь заполнится.");
            resource.wait();
            System.out.println("Поток " + getName() + " возобновил работу.");
            number = resource.getElement();
            System.out.println("Поток " + getName() + " извлёк число" + number);
        }
    }

    private void setIntegerFromResource() throws InterruptedException {
        Integer number = rnd.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}

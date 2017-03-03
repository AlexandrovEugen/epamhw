package com.epam.java.se.hw6;

import com.epam.java.se.hw7.Move;

public class NuclearSubmarine {

    private boolean itsMoving = false;
    private Engine engine;


    public void startEngine(){
        engine = new Engine();
    }



    @Move(enginIsStared = true)
    public void move(){
        if (engine == null){
            System.out.println("at the beginning please start engine");
        }
        else {
            engine.startMoving();
        }
    }

    public void stop(){
        if (isItsMoving()){
            engine.stop();
        }
    }

    public boolean isItsMoving() {
        return itsMoving;
    }

    private class Engine {

        private void startMoving(){

            itsMoving = true;
        }

        private void stop() {
            System.out.println("stop submarine");
            itsMoving = false;
        }
    }

}

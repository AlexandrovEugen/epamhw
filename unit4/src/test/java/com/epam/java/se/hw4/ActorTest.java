package com.epam.java.se.hw4;


import org.junit.Test;

public class ActorTest {

    @Test(expected = NullPointerException.class)
    public void testThatActorMustHasAName(){
        Actor actor = new Actor(null, "Parker", Actor.Sex.male);
    }

    @Test(expected = NullPointerException.class)
    public void testThatActorMustHasASureName(){
        Actor actor = new Actor("Stacy", null, Actor.Sex.female);
    }
}
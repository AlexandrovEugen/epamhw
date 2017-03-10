package com.epam.java.se.hw4;


import org.junit.Test;

public class MovieTest {

    @Test(expected = NullPointerException.class)
    public void testThatMovieMustHaasANAme(){
        new Movie(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatMustHasMainCastOfActors(){
        Movie movie = new Movie("Titanic");
        movie.addActor(new Actor("Leonardo", "Dicaprio", Actor.Sex.female));
        movie.addActress(new Actor("Kate", "Winslate", Actor.Sex.female));
    }
}
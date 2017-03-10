package com.epam.java.se.hw4;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieCollectionTest {

    @Test
    public void testThatInCollectionOneMovieCanBeAddedOnce(){
        Movie titanic = new Movie("Titanic");
        titanic.addActor(new Actor("Leonardo", "Dicaprio", Actor.Sex.male));
        titanic.addActress(new Actor("Kate", "Winslet", Actor.Sex.female));

        Movie titanic1 = new Movie("Titanic");
        titanic1.addActor(new Actor("Leonardo", "Dicaprio", Actor.Sex.male));
        titanic1.addActress(new Actor("Kate", "Winslet", Actor.Sex.female));

        Movie desperados = new Movie("Desperados");
        desperados.addActor(new Actor("Antonio", "Banderos", Actor.Sex.male));
        desperados.addActress(new Actor("Salma", "Hayek", Actor.Sex.female));

        MovieCollection mc = new MovieCollection();
        mc.addMovie(titanic);
        mc.addMovie(titanic1);
        mc.addMovie(desperados);

        assertEquals(2, mc.collectionsSize());
    }

}
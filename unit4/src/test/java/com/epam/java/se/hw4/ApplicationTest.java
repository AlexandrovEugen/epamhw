package com.epam.java.se.hw4;


import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    MovieCollection collection;

    @Before
    public void initializeAndFill(){
        collection = new MovieCollection();
        Movie titanic = new Movie("Titanic");
        titanic.addActor(new Actor("Leonardo", "Dicaprio", Actor.Sex.male));
        titanic.addActress(new Actor("Kate", "Winslet", Actor.Sex.female));

        Movie titanic2 = new Movie("Titanic2");
        titanic2.addActor(new Actor("Leonardo", "Dicaprio", Actor.Sex.male));
        titanic2.addActress(new Actor("Kate", "Winslet", Actor.Sex.female));

        Movie desperados = new Movie("Desperados");
        desperados.addActor(new Actor("Antonio", "Banderos", Actor.Sex.male));
        desperados.addActress(new Actor("Salma", "Hayek", Actor.Sex.female));

        Movie lalaland = new Movie("La-la-land");
        lalaland.addActor(new Actor("Ryan", "Gosling", Actor.Sex.male));
        lalaland.addActress(new Actor("Emma", "Stone", Actor.Sex.female));

        Movie inception = new Movie("Inception");
        inception.addActor(new Actor("Leonardo", "Dicaprio", Actor.Sex.male));
        inception.addActress(new Actor("Marion", "Cotillard", Actor.Sex.female));

        Movie drive = new Movie("Drive");
        drive.addActor(new Actor("Ryan", "Gosling", Actor.Sex.male));
        drive.addActress(new Actor("Carey", "Mulligan", Actor.Sex.female));
        collection.addMovie(titanic);
        collection.addMovie(titanic2);
        collection.addMovie(desperados);
        collection.addMovie(lalaland);
        collection.addMovie(inception);
        collection.addMovie(drive);
    }

    @Test
    public void testThatApplicationCanSaveAndDownloadCollection(){

        Application app = new Application(collection);
        app.save("collections.ser");

        MovieCollection downloadedCollection = app.download("collections.ser");
        Set<Movie> downloadedCollections = downloadedCollection.getCollections();

        Set<Movie> collections = collection.getCollections();

        for (Movie movie: downloadedCollections) {
            assertTrue(collections.contains(movie));
        }
    }


}
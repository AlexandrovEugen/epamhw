package com.epam.java.se.hw4;


import java.util.HashSet;
import java.util.Set;

public class MovieCollection {

    private final Set<Movie> collections;

    public MovieCollection(){
        collections = new HashSet<>();
    }

    public void addMovie(Movie movie) {
        collections.add(movie);
    }

    public int collectionsSize() {
        return collections.size();
    }

    public Set<Movie> getCollections() {
        return collections;
    }
}

package com.epam.java.se.hw4;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MovieCollection  implements Serializable{

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

    public void removeMovieByName(String title){
        collections.stream().filter(o -> o.getTitle().equals(title)).forEach(collections::remove);
    }
}

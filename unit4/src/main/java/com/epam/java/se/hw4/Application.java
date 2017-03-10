package com.epam.java.se.hw4;


import java.util.Objects;

public class Application {


    private final MovieCollection collection;

    public Application(MovieCollection collection) {
        Objects.requireNonNull(collection);
        this.collection = collection;
    }

    public void save(String fileName) {
        Serializer serializer  = new Serializer(collection);
        serializer.serializeAndGoToFile(fileName);
    }

    public MovieCollection download(String fileName) {
        Deserializer deserializer = new Deserializer(fileName);
        return deserializer.getFromFileAndDeserialize();
    }
}

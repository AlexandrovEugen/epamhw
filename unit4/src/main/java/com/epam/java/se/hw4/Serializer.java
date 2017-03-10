package com.epam.java.se.hw4;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Serializer implements Serializable {

    private MovieCollection collection;

    public Serializer(MovieCollection collection){
        this.collection = collection;
    }

    public void serializeAndGoToFile(String fileName){
        Objects.requireNonNull(fileName);
        Objects.requireNonNull(collection);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            outputStream.writeObject(collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

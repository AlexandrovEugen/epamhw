package com.epam.java.se.hw4;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public class Deserializer  implements Serializable{

    private final String fileName;

    private MovieCollection collection;

    public Deserializer(String fileName){
        Objects.requireNonNull(fileName);
        this.fileName = fileName;
    }

    public MovieCollection getFromFileAndDeserialize(){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            collection = (MovieCollection)inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return collection;
    }

}

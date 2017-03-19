package com.epam.java.se.hw2;


import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UniversalPropertyReader {

    private ReadProperty strings;
    private ReadProperty longs;
    private ReadProperty ints;
    private ReadProperty doubles;

    public void read(String filename) {
        ExecutorService ex = Executors.newCachedThreadPool();
        try {
            doubles = new ReadProperty(filename, ReadProperty.Types.doubletype);
            strings = new ReadProperty(filename, ReadProperty.Types.stringtype);
            ints = new ReadProperty(filename, ReadProperty.Types.inttype);
            longs = new ReadProperty(filename, ReadProperty.Types.longtype);
        } catch (FileNotFoundException | NoSuchFileException e) {
            e.printStackTrace();
        }
        ex.execute(doubles);
        ex.execute(strings);
        ex.execute(ints);
        ex.execute(longs);
        ex.shutdown();
    }

    public Set<Long> readValForLong() {
        return longs.getLongValues();
    }

    public Set<Integer> readValForInt() {

        return ints.getIntValues();
    }

    public Set<String> readValForString() {

        return strings.getStringValues();
    }

    public Set<Double> readValForDouble() {

        return doubles.getDoubleValues();
    }
}

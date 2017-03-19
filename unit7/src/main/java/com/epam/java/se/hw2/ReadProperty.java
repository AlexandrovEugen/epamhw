package com.epam.java.se.hw2;


import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadProperty extends Thread {


    private final Types type;
    private ResourceBundle resourceBundle;
    private static Lock lock = new ReentrantLock();

    private final Set<Long> longValues = new HashSet<>();

    private final Set<Integer> intValues = new HashSet<>();
    private final Set<Double> doubleValues = new HashSet<>();
    private final Set<String> stringValues = new HashSet<>();
    enum Types {

        stringtype("string[0-9]{1,2}"), longtype("long[0-9]{1,2}"),

        inttype("integer[0-9]{1,2}"), doubletype("double[0-9]{1,2}");


        private final String match;

        Types(String match) {
            this.match = match;
        }

        public String getMatch() {
            return match;
        }

    }
    public ReadProperty(String fileName, Types type) throws FileNotFoundException, NoSuchFileException {
        Objects.requireNonNull(fileName);
        Objects.requireNonNull(type);
//        File file = new File(fileName).getAbsoluteFile();
//        if (!file.exists() || file.isDirectory()){
//            throw new FileNotFoundException();
//        }
//        if (file.length() == 0){
//            throw new NoSuchFileException("Empty file");
//        }
        resourceBundle = ResourceBundle.getBundle(fileName, new Locale("en"));
        this.type = type;
    }

    public Set<Long> getLongValues() {
        return longValues;
    }

    public Set<Integer> getIntValues() {
        return intValues;
    }

    public Set<Double> getDoubleValues() {
        return doubleValues;
    }

    public Set<String> getStringValues() {
        return stringValues;
    }


    @Override
    public void run() {
        for (String key: resourceBundle.keySet()) {
            lock.lock();
            if (key.matches(type.getMatch())){
                switch (type){
                    case stringtype:{
                        stringValues.add(resourceBundle.getString(key));
                    }
                    break;
                    case doubletype:{
                        doubleValues.add(Double.valueOf(resourceBundle.getString(key)));
                    }
                    break;
                    case inttype:{
                        intValues.add(Integer.valueOf(resourceBundle.getString(key)));
                    }
                    break;
                    case longtype:{
                        longValues.add(Long.valueOf(resourceBundle.getString(key)));
                    }
                }
            }
            lock.unlock();
        }
    }
}

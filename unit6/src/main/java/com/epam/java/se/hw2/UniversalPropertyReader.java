package com.epam.java.se.hw2;


import java.util.*;
import java.util.stream.Collectors;

public class UniversalPropertyReader {


    private final Map<String, String> map = new HashMap<>();


    public void load(String propertyfile) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyfile, new Locale("en"));
        for (String key: resourceBundle.keySet()){
            map.put(String.valueOf(key), String.valueOf(resourceBundle.getString(key)));
        }
    }

    public Set<String> getKeys() {
        return map.keySet();
    }

    public Set<String> getValues(){
        return map.values().stream().collect(Collectors.toSet());
    }

    public Map<String, String> getMap() {
        return map;
    }
}

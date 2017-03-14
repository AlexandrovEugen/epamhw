package com.epam.java.se.hw2.classes;


import com.epam.java.se.hw2.exeptions.NoSuchKeyFromPropertyFile;
import com.epam.java.se.hw2.exeptions.PropertiesFileNotFoundException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyLoader{

    private final Properties properties = new Properties();
    private final Map<String, Object> store = new HashMap<>();


    public void load(String s) throws PropertiesFileNotFoundException {
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(s)))){
                properties.load(br);
            }
        } catch (IOException e) {
            throw new PropertiesFileNotFoundException();
        }
        for (String keys : properties.stringPropertyNames()) {
            Object value = properties.getProperty(keys);
            store.put(keys, value);
        }

    }


    public PropertyLoader getDefaultBundle() {
        return this;
    }

    public Object getString(String key) {
        if(store.containsKey(key)){
           return store.get(key);
        }
        else {
            throw new NoSuchKeyFromPropertyFile(NoSuchKeyFromPropertyFile.class.getName());
        }
    }
}

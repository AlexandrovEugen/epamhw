package com.epam.java.se.hw3;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SharedResource {

    private final List<Integer> list;

    public SharedResource(){
        list = new ArrayList<>();
    }

    public void setElement(Integer element){
        Objects.requireNonNull(element);
        list.add(element);
    }

    public Integer getElement(){
        if (list.size() > 0){
            return list.remove(0);
        }
        return null;
    }


}

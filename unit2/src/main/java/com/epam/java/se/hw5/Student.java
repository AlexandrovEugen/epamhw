package com.epam.java.se.hw5;


import java.util.HashMap;
import java.util.Map;


public class Student {

    private final String name;
    private final String surname;

    private final Map<Disciplines, Mark> disciplinesSet = new HashMap<>();

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addDiscipline(Disciplines disciplines, Mark mark) {
        checkArguments(disciplines, mark);
        disciplinesSet.put(disciplines, mark);
    }

    private void checkArguments(Disciplines disciplines, Mark mark) {
        if (disciplines.isInt()){
            if (mark.getMark().getClass() != Integer.class){
                throw new IllegalArgumentException();
            }
        }
        else if (mark.getMark().getClass() != Double.class){
            throw new IllegalArgumentException();
        }
    }

    public Map<Disciplines, Mark> getDisciplinesMap() {
        Map<Disciplines, Mark> tmp  = disciplinesSet;
        return tmp;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

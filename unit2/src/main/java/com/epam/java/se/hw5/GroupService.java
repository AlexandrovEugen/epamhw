package com.epam.java.se.hw5;

import java.util.Set;
import java.util.stream.Collectors;

public class GroupService{

    public Set<Disciplines> getDisciplineList(Student student) {
        Set<Disciplines> disciplinesSet =  student.getDisciplinesMap().keySet();
        return disciplinesSet;
    }

    public Set<Disciplines> filterDisciplineListByUpperBound(Student student, Double upperBound) {
        Set<Disciplines> disciplines = student.getDisciplinesMap().entrySet().stream().
                                       filter(o -> o.getValue().compareTo(upperBound) >= 0).collect(Collectors.
                                       toMap(p -> p.getKey(), p -> p.getValue())).keySet();
        return disciplines;
    }

    public Set<Disciplines> filterDisciplineListByLowerBound(Student student, Double lowerBound) {
        Set<Disciplines> disciplines = student.getDisciplinesMap().entrySet().stream().filter(o -> o.getValue().compareTo(lowerBound) <= 0).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())).keySet();
        return disciplines;
    }
}

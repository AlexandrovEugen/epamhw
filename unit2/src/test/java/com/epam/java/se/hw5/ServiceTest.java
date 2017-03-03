package com.epam.java.se.hw5;


import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ServiceTest {

    @Test
    public void testThatGetDisciplineListMethodWorksRight() {
        Student student = new Student("John", "Doe");
        student.addDiscipline(Disciplines.Chemistry, new IntMark<>(5));
        student.addDiscipline(Disciplines.Math, new DoubleMark<>(4.8));
        student.addDiscipline(Disciplines.Philosophy, new IntMark<>(4));
        student.addDiscipline(Disciplines.Physics, new DoubleMark<>(3.8));
        student.addDiscipline(Disciplines.Literature, new IntMark<>(4));
        GroupService service = new GroupService();
        Set<Disciplines> studentSet = service.getDisciplineList(student);
        assertTrue(studentSet.contains(Disciplines.Chemistry));
        assertTrue(studentSet.contains(Disciplines.Math));
        assertTrue(studentSet.contains(Disciplines.Philosophy));
        assertTrue(studentSet.contains(Disciplines.Physics));
        assertTrue(studentSet.contains(Disciplines.Literature));
    }


    @Test
    public void testThatGetFilteredDisciplineMethodWorksRight(){
        Student student = new Student("John", "Doe");
        student.addDiscipline(Disciplines.Chemistry, new IntMark<>(5));
        student.addDiscipline(Disciplines.Math, new DoubleMark<>(5.0));
        student.addDiscipline(Disciplines.Philosophy, new IntMark<>(4));
        student.addDiscipline(Disciplines.Physics, new DoubleMark<>(4.8));
        student.addDiscipline(Disciplines.Literature, new IntMark<>(4));
        GroupService service = new GroupService();
        Set<Disciplines> filtered1 = service.filterDisciplineListByUpperBound(student, 5.0);
        assertTrue(filtered1.contains(Disciplines.Chemistry));
        assertTrue(filtered1.contains(Disciplines.Math));
        assertFalse(filtered1.contains(Disciplines.Philosophy));
        Set<Disciplines> filtered2 = service.filterDisciplineListByLowerBound(student, 2.0);
        assertTrue(filtered2.isEmpty());
    }
}

package com.epam.java.se.hw4;



import com.epam.java.se.hw3.OfficeTool.*;
import com.epam.java.se.hw3.Pen;
import com.epam.java.se.hw3.Pen.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CollectionImplTest {
    @Test
    public void testThatSortByCostWorksRight() throws Exception {
        List<Pen> testData = new ArrayList<>();
        testData.add(new Pen(9000000L, Colour.black, typeOfMaterial.metallic, "Parker", 100, ColourOfInc.black,  TypeOfPen.rollerball));
        testData.add(new Pen(555L, Colour.black, typeOfMaterial.plastic, "Bic", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(100L, Colour.black, typeOfMaterial.plastic, "Pilot", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(111L, Colour.black, typeOfMaterial.plastic, "Epam", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(10L, Colour.black, typeOfMaterial.plastic, "Oracle", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(90L, Colour.black, typeOfMaterial.plastic, "T-Systems", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(8000L, Colour.black, typeOfMaterial.plastic, "Cross", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(200L, Colour.black, typeOfMaterial.plastic, "Laban", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(100L, Colour.black, typeOfMaterial.plastic, "Caran d'Ache", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(7000L, Colour.black, typeOfMaterial.plastic, "Parker", 100, ColourOfInc.black,  TypeOfPen.technical));
        CollectionImpl<Pen> penCollection = new CollectionImpl<>();
        penCollection.sortByCost(testData);
        for (int i = 1; i < testData.size(); i++) {
            assertTrue(testData.get(i - 1).getCost() <= testData.get(i).getCost());
        }
    }

    @Test
    public void testThatSortByNameWorksRight() throws Exception {
        List<Pen> testData = new ArrayList<>();
        testData.add(new Pen(9000000L, Colour.black, typeOfMaterial.metallic, "Parker", 100, ColourOfInc.black,  TypeOfPen.rollerball));
        testData.add(new Pen(555L, Colour.black, typeOfMaterial.plastic, "Bic", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(100L, Colour.black, typeOfMaterial.plastic, "Pilot", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(111L, Colour.black, typeOfMaterial.plastic, "Epam", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(10L, Colour.black, typeOfMaterial.plastic, "Oracle", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(90L, Colour.black, typeOfMaterial.plastic, "T-Systems", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(8000L, Colour.black, typeOfMaterial.plastic, "Cross", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(200L, Colour.black, typeOfMaterial.plastic, "Laban", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(100L, Colour.black, typeOfMaterial.plastic, "Caran d'Ache", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(7000L, Colour.black, typeOfMaterial.plastic, "Parker", 100, ColourOfInc.black,  TypeOfPen.technical));
        CollectionImpl<Pen> penCollection = new CollectionImpl<>();
        penCollection.sortByName(testData);
        for (int i = 1; i < testData.size(); i++) {
            assertTrue(testData.get(i - 1).getName().compareTo(testData.get(i).getName()) <= 0);
        }
    }
    @Test
    public void testThatSortByNameAndCostWorksRight() throws Exception {
        List<Pen> testData = new ArrayList<>();
        testData.add(new Pen(9000000L, Colour.black, typeOfMaterial.metallic, "Parker", 100, ColourOfInc.black,  TypeOfPen.rollerball));
        testData.add(new Pen(555L, Colour.black, typeOfMaterial.plastic, "Bic", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(100L, Colour.black, typeOfMaterial.plastic, "Pilot", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(111L, Colour.black, typeOfMaterial.plastic, "Epam", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(10L, Colour.black, typeOfMaterial.plastic, "Oracle", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(90L, Colour.black, typeOfMaterial.plastic, "T-Systems", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(8000L, Colour.black, typeOfMaterial.plastic, "Cross", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(200L, Colour.black, typeOfMaterial.plastic, "Laban", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(100L, Colour.black, typeOfMaterial.plastic, "Caran d'Ache", 100, ColourOfInc.black,  TypeOfPen.technical));
        testData.add(new Pen(7000L, Colour.black, typeOfMaterial.plastic, "Parker", 100, ColourOfInc.black,  TypeOfPen.technical));
        List<Pen> benchMark = testData;
        CollectionImpl<Pen> penCollection = new CollectionImpl<>();
        penCollection.sortByName(benchMark);
        penCollection.sortByCost(benchMark);
        penCollection.sortByNameAndCost(testData);
        for (int i = 0; i < testData.size(); i++) {
            assertEquals(testData.get(i).getCost(),benchMark.get(i).getCost());
            assertEquals(testData.get(i).getName(),benchMark.get(i).getName());
        }
    }

}
package com.epam.java.se.hw4.api;


import com.epam.java.se.hw3.OfficeTool;

import java.util.List;

public interface Collection<E extends OfficeTool>{

    void sortByCost(List<E> list);

    void sortByName(List<E> list);

    void sortByNameAndCost(List<E> list);
}

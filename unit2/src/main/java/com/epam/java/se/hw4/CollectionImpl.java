package com.epam.java.se.hw4;


import com.epam.java.se.hw3.OfficeTool;
import com.epam.java.se.hw4.api.Collection;

import java.util.Collections;
import java.util.List;

public class CollectionImpl<E extends OfficeTool> implements Collection<E>{

    public void sortByCost(List<E> list) {
        Collections.sort(list, (o1, o2) -> {
            Long c1 = o1.getCost();
            Long c2 = o2.getCost();
            return c1.compareTo(c2);
        });
    }


    public void sortByName(List<E> list) {
        Collections.sort(list, (o1, o2) -> {
            String n1 = o1.getName();
            String n2 = o2.getName();
            return n1.compareTo(n2);
        });
    }


    public void sortByNameAndCost(List<E> list) {
        Collections.sort(list, (o1, o2) -> {
            String n1 = o1.getName();
            String n2 = o2.getName();
            int comp = n1.compareTo(n2);
            if (comp != 0){
                return comp;
            }
            Long c1 = o1.getCost();
            Long c2 = o2.getCost();
            return c1.compareTo(c2);
        });
    }
}

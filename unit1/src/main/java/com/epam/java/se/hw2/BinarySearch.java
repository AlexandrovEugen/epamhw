package com.epam.java.se.hw2;

import java.util.List;


public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    public int findItem(List<E> data, E itemToFind) {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i - 1).compareTo(data.get(i)) > 0){
                throw new IllegalStateException();
            }
        }
        return search(data, itemToFind, 0, data.size());
    }

    private int search(List<E> data, E key, int lo, int high) {
        int middle = lo + ((high - lo)/2);
        if (lo >= high){
            return -1;
        }
        if (key.compareTo(data.get(middle))== 0){
            return middle;
        }
        else if (key.compareTo(data.get(middle)) > 0){
            return search(data, key, middle + 1, high);
        }
        else {
            return search(data, key, lo, middle);
        }
    }
}

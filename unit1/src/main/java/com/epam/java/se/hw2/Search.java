package com.epam.java.se.hw2;

import java.util.List;


interface Search<E extends Comparable<E>> {

    int findItem(List<E> data, E itemToFind);
}

package com.epam.java.se.hw3;


public class MergeSort implements Sort<Comparable> {


    public void buttonUpSort(Comparable[] data) {
        final int dataSize = data.length;
        Comparable[] tmp = new Comparable[dataSize];
        int step = 1;
        while (step <= dataSize){
            int lo  = 0;
            while (lo < dataSize){
                int hi = Math.min(lo + step, dataSize);
                int middle = lo + (hi - lo)/2;
                merge(data, tmp, lo, middle, hi);
                lo += step;
            }
            step *= 2;
        }
        if (dataSize - step/2 > 0){
            final int lo = 0;
            final int divider = step/2;
            merge(data, tmp, lo, divider, dataSize);
        }
    }

    private void merge(Comparable[] data, Comparable[] tmp, int lo, int middle, int hi) {
        System.arraycopy(data, lo, tmp, lo, hi - lo);
        int i = lo;
        int j = middle;
        for (int k = lo; k < hi; k++) {
            if (i == middle){
                data[k] = tmp[j];
                j = j + 1;
            }
            else if (j == hi){
                data[k] = tmp[i];
                i = i + 1;
            }
            else if (tmp[i].compareTo(tmp[j]) > 0){
                data[k] = tmp[j];
                j = j + 1;
            }
            else {
                data[k] = tmp[i];
                i = i + 1;
            }
        }
    }
}

package com.epam.java.se.hw1;


import java.util.Arrays;

public class IntSet implements BinSet {

    long[] data;

    public IntSet(){
        this(new long[1]);
    }

    private IntSet(long[] data){
        this.data = data;
    }

    public void add(int value) {
        int indexInArray = delegateTo(value);
        int position = findPosition(value);

        if (enoughCapacity(indexInArray)){
           if (position < 0){
               return;
           }
           else {
               data[indexInArray] |= 1L << position;
           }
        }
        else {
            increaseCapacity(indexInArray + 1);
            if (position < 0){
                return;
            }
            else {
                data[indexInArray] |= 1L << position;
            }
        }
    }

    public void remove(int value) {
        int indexInArray = delegateTo(value);
        int position = findPosition(value);

        if (enoughCapacity(indexInArray)){
            if (position < 0){
                return;
            }
            else {
                data[indexInArray] &= ~(1L << position);
            }
        }
        else {
            increaseCapacity(indexInArray + 1);
            if (position < 0){
                return;
            }
            else {
                data[indexInArray] &= ~(1L << position);
            }
        }
    }

    public boolean contains(int value) {
        int indexInArray = delegateTo(value);
        int position = findPosition(value);
        if (data.length - 1 < indexInArray){
            return false;
        }
        else if (position < 0) {
            return false;
        }
        final long mask = 1L << value;
        final long res = data[indexInArray] & mask;
        return res != 0;
    }

    public boolean isSubSet(IntSet set) {
        if (this.data.length > set.data.length){
            return false;
        }
        else {
            for (int i = 0; i < this.data.length; i++) {
                final long union = set.data[i] | this.data[i];
                if (set.data[i] != union){
                    return false;
                }
            }
        }
        return true;
    }

    public IntSet union(IntSet other) {
        final long[] result;
        if (this.data.length > other.data.length){
            result = new long[this.data.length];
            for (int i = 0; i < other.data.length; i++) {
                result[i] = data[i] | other.data[i];
            }
        }
        else {
            result = new long[other.data.length];
            for (int i = 0; i < this.data.length; i++) {
                result[i] = data[i] | other.data[i];
            }
        }
        return new IntSet(result);
    }

    public IntSet intersect(IntSet other) {
        final long[] result;
        if (this.data.length > other.data.length){
            result = new long[this.data.length];
            for (int i = 0; i < this.data.length; i++) {
                if (i < other.data.length){
                    result[i] = this.data[i] & other.data[i];
                }
                else {
                    result[i] = 0b0;
                }
            }
        }
        else {
            result = new long[other.data.length];
            for (int i = 0; i < other.data.length; i++) {
                if (i < this.data.length){
                    result[i] = this.data[i] & other.data[i];
                }
                else {
                    result[i] = 0b0;
                }
            }
        }
        return new IntSet(result);
    }

    private void increaseCapacity(int length) {
        data = Arrays.copyOf(data, length);
    }

    private boolean enoughCapacity(int indexInArray) {
        return data.length - 1 >= indexInArray;
    }

    private int findPosition(int value) {
        return value % 64;
    }

    private int delegateTo(int value) {
        return value / 64;
    }
}

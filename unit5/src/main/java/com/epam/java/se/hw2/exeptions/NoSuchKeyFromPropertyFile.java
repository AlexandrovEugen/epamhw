package com.epam.java.se.hw2.exeptions;

import static java.util.Objects.requireNonNull;

public class NoSuchKeyFromPropertyFile extends RuntimeException {

    public NoSuchKeyFromPropertyFile(String message){
        super(requireNonNull(message));
    }

    public NoSuchKeyFromPropertyFile(String message, Throwable cause){
        super(requireNonNull(message), requireNonNull(cause));
    }
}

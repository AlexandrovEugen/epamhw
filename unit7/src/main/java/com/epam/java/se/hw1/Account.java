package com.epam.java.se.hw1;


import java.util.Objects;

public class Account {

    private Long balance;
    private Object id;

    public Account(Long balance) {
        Objects.requireNonNull(balance);
        if (balance.compareTo(0L) < 0){
            throw new IllegalArgumentException();
        }
        this.balance = balance;
    }


    public void deposit(Long amount) {
        Objects.requireNonNull(amount);
        if (amount.compareTo(0L) < 0){
            throw new IllegalArgumentException();
        }
        balance = balance + amount;
    }

    public void withdraw(Long amount){
        Objects.requireNonNull(amount);
        if (amount.compareTo(0L) < 0){
            throw new IllegalArgumentException();
        }
        balance = balance - amount;
    }


    public Long getBalance() {
        return balance;
    }

    public Object getId() {
        return id;
    }
}

package com.epam.java.se.hw1;


import java.util.Objects;

public class Account {

    private final Integer id;
    private Long balance;

    public Account(Integer id, Long balance) {
        this.id = id;
        Objects.requireNonNull(balance);
        if (balance.compareTo(0L) < 0) {
            throw new IllegalArgumentException();
        }
        this.balance = balance;
    }


    public void deposit(Long amount) {
        Objects.requireNonNull(amount);
        if (amount.compareTo(0L) < 0) {
            throw new IllegalArgumentException();
        }
        balance = balance + amount;
    }

    public void withdraw(Long amount) {
        Objects.requireNonNull(amount);
        if (amount.compareTo(0L) < 0) {
            throw new IllegalArgumentException();
        }
        balance = balance - amount;
    }

    public Long getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;

        if (!this.id.equals(account.getId())) return false;
        return this.balance.equals(account.getBalance());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 13 * result + balance.hashCode();
        return result;
    }
}

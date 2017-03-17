package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.Account;

import java.util.List;
import java.util.Objects;

public class DepositOperation extends Thread {

    private final Account account;
    private final List<Long> setters;

    /**
     *
     * @param account
     * @param setters list of amounts for deposit to this account
     */
    public DepositOperation(Account account, List<Long> setters) {
        Objects.requireNonNull(account);
        Objects.requireNonNull(setters);
        if (setters.isEmpty()){
            throw new IllegalArgumentException("There're no operations");
        }
        this.account = account;
        this.setters = setters;
    }

    @Override
    public void run() {
        synchronized (account){
            for (Long amount: setters) {
                account.deposit(amount);
            }
        }
    }
}

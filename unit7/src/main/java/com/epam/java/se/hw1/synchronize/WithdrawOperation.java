package com.epam.java.se.hw1.synchronize;

import com.epam.java.se.hw1.Account;

import java.util.List;
import java.util.Objects;


public class WithdrawOperation extends Thread {

    private final Account account;
    private final List<Long> getters;


    /**
     * @param getters list of  amounts for withdraw from this account
     */

    public WithdrawOperation(Account account, List<Long> getters){
        this.getters = getters;
        Objects.requireNonNull(account);
        Objects.requireNonNull(getters);
        if (getters.isEmpty()){
            throw  new IllegalArgumentException("There're no operations");
        }
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account){
            for (Long amount: getters){
                account.withdraw(amount);
            }
        }
    }
}

package com.epam.java.se.hw1.synchronize;

import com.epam.java.se.hw1.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class BankOperations {

    private final Account account;
    private DepositOperation deposit;
    private WithdrawOperation withdraw;



    public BankOperations(Account account) {
        Objects.requireNonNull(account);
        this.account = account;
    }

    public void addOperations(Map<String,Long> operations){
        List<Long> setters = new ArrayList<>(operations.entrySet().stream().filter(o -> o.getKey().equals("set")).collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue())).values());
        List<Long> getters = new ArrayList<>(operations.entrySet().stream().filter(o -> o.getKey().equals("get")).collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue())).values());
        deposit = new DepositOperation(account, setters);
        withdraw = new WithdrawOperation(account, getters);
    }

    public void doTransactions() throws InterruptedException {
        deposit.start();
        withdraw.start();
        deposit.join();
        withdraw.join();
    }

}


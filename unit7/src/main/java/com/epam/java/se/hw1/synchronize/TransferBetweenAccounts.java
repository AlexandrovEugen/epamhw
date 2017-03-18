package com.epam.java.se.hw1.synchronize;

import com.epam.java.se.hw1.Account;

import java.util.List;
import java.util.Objects;


public class TransferBetweenAccounts extends Thread{

    private final Account sender;
    private final Account receiver;
    private final Account lock1;
    private final Account lock2;
    private final List<Long> transferSums;

    public TransferBetweenAccounts(Account sender, Account receiver, List<Long> transferSums) {
        Objects.requireNonNull(sender);
        Objects.requireNonNull(receiver);
        Objects.requireNonNull(transferSums);
        if (transferSums.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.sender = sender;
        this.receiver = receiver;
        this.transferSums = transferSums;

        if (sender.getId().compareTo(receiver.getId()) == 0){
            throw new IllegalArgumentException();
        }
        else if (sender.getId().compareTo(receiver.getId()) < 0){
            lock1 = sender;
            lock2 = receiver;
        }
        else {
            lock1 = receiver;
            lock2 = sender;
        }
    }

    private   void doTransfer(){
        synchronized (lock1){
            synchronized (lock2){
                for (Long amount: transferSums) {
                    sender.withdraw(amount);
                    receiver.deposit(amount);
                }
            }
        }
    }

    @Override
    public void run() {
        doTransfer();
    }
}

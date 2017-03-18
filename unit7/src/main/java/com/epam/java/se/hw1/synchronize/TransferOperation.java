package com.epam.java.se.hw1.synchronize;

import com.epam.java.se.hw1.Account;
import com.epam.java.se.hw1.Sender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransferOperation{

    private final List<Sender> senders;
    private final List<TransferBetweenAccounts>  betweenAccounts = new ArrayList<>();

    public TransferOperation(List<Sender> senders){
        Objects.requireNonNull(senders);
        if (senders.isEmpty()){
            throw new IllegalArgumentException("Empty list of Nodes for Senders");
        }
        this.senders = senders;
    }

    public void doTransfer(){
        initThreads();
        for (TransferBetweenAccounts doStart : betweenAccounts) {
            doStart.start();
            try {
                doStart.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void initThreads(){
        for (Sender sender : senders) {
            for (Account account: sender.getAccountsOperations().keySet()) {
                betweenAccounts.add(new TransferBetweenAccounts(sender.getAccount(), account, sender.getAccountsOperations().get(account)));
            }
        }
    }
}

package com.epam.java.se.hw1.synchronize;

import com.epam.java.se.hw1.Account;

/**
 * Created by Евгений on 16.03.2017.
 */
public class TransferOperation {

    private final Account sender;
    private final Account receiver;
    private final Long paymentAmount;


    public TransferOperation(Account sender, Account receiver, Long paymentAmount) {
        this.sender = sender;
        this.receiver = receiver;
        this.paymentAmount = paymentAmount;
    }
}

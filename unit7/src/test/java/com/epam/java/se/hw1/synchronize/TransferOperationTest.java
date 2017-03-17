package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.Account;
import com.epam.java.se.hw1.Sender;
import com.epam.java.se.hw1.XMLLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransferOperationTest {


    private TransferOperation transferOperation;
    private List<Account> accounts;
    private List<Account> testAccounts;

    @Before
    public void load(){
        final XMLLoader xmlLoader = new XMLLoader();
        xmlLoader.load("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit7\\src\\main\\resources\\transaction_operations.xml");

        final List<Sender> senders = xmlLoader.getSenders();

        testAccounts = xmlLoader.loadTestAccounts();
        accounts = xmlLoader.loadAccounts();
        transferOperation = new TransferOperation(senders);
    }



    @Test
    public void testThatAtTheAndWeGotValidBalanceValueOnBothAccounts(){
        transferOperation.doTransfer();
        Account[] realBalance = (Account[]) accounts.toArray();
        Account[] benchmark = (Account[]) testAccounts.toArray();
        for (int i = 0; i < realBalance.length; i++) {
            for (Account aBenchmark : benchmark) {
                if (realBalance[i].getId().equals(aBenchmark.getId())) {
                    assertEquals(realBalance[i].getBalance(), (benchmark[i].getBalance()));
                }
            }
        }
    }



}
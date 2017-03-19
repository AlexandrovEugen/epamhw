package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.Account;
import com.epam.java.se.hw1.Sender;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransferOperationTest {


    private final ThreadLocal<TransferOperation> transferOperation = new ThreadLocal<>();
    private XMLLoader xmlLoader = new XMLLoader();
    List<Sender> senders;

    @Before
    public void load(){
        xmlLoader.load("epamhw\\unit7\\src\\main\\resources\\transaction_operations.xml");
        senders = xmlLoader.getSenders();

    }



    @Test
    public void testThatAtTheAndWeGotValidBalanceValueOnBothAccounts(){
        transferOperation.set(new TransferOperation(senders));
        transferOperation.get().doTransfer();
        List<Account> accounts = xmlLoader.getAccounts();
        List<Account> testAccounts = xmlLoader.getTestAccount();
        assertEquals(accounts.size(), testAccounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            assertEquals(accounts.get(i).getId(),(testAccounts.get(i).getId()));
            assertEquals(accounts.get(i).getBalance(),(testAccounts.get(i).getBalance()));
        }
    }




}
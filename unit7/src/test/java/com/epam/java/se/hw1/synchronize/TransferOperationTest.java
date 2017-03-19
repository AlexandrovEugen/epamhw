package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.Account;
import com.epam.java.se.hw1.Sender;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransferOperationTest {


    private TransferOperation transferOperation;
    private List<Account> accounts;
    private List<Account> testAccounts;
    private XMLLoader xmlLoader = new XMLLoader();
    @Before
    public void load(){
        xmlLoader.load("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit7\\src\\main\\resources\\transaction_operations.xml");
        final List<Sender> senders = xmlLoader.getSenders();
        transferOperation = new TransferOperation(senders);
    }



    @Test
    public void testThatAtTheAndWeGotValidBalanceValueOnBothAccounts(){
        transferOperation.doTransfer();
        accounts = xmlLoader.getAccounts();
        testAccounts = xmlLoader.getTestAccount();
        assertEquals(accounts.size(), testAccounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            assertEquals(accounts.get(i).getId(),(testAccounts.get(i).getId()));
            assertEquals(accounts.get(i).getBalance(),(testAccounts.get(i).getBalance()));
        }
    }




}
package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.Account;
import com.epam.java.se.hw1.XMLLoader;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BankOperationsTest {

    private Map<String, Long> operations;
    private Account account;

    @Before
    public void load() {
        final XMLLoader loader = new XMLLoader();
        loader.load("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit7\\src\\main\\resources\\client_operations.xml");

        final Long initialSum = loader.getInitialSum();

        operations = loader.parseOperationsToMap();
        account = new Account(initialSum);
    }


    @Test
    public void testThatBanksOperationsInMultiThreading() {
        BankOperations bankOperations = new BankOperations(account);
        bankOperations.addOperations(operations);
        try {
            bankOperations.doTransactions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long benchmark = 700L;
        assertEquals(benchmark, account.getBalance());
    }
}
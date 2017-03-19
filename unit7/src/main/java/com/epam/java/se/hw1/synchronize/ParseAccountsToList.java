package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.Account;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ParseAccountsToList  extends Thread{

    private final NodeList nodeList;
    private final List<Account> accounts = new ArrayList<>();

    public ParseAccountsToList(NodeList accounts) {
        this.nodeList = accounts;
    }

    public List<Account> getAccounts(){
        return accounts;
    }


    @Override
    public void run() {
        parseAccountsToList();
    }

    private void parseAccountsToList() {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Integer id = Integer.valueOf(element.getElementsByTagName("id").item(0).getTextContent());
                Long balance = Long.valueOf(element.getElementsByTagName("balance").item(0).getTextContent());
                Account account = new Account(id, balance);
                accounts.add(account);
                System.out.println(accounts.size() + " " + account.getId() + " " + account.getBalance());
            }
        }
    }
}

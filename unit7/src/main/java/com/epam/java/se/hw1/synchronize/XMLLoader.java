package com.epam.java.se.hw1.synchronize;

import com.epam.java.se.hw1.Account;
import com.epam.java.se.hw1.Sender;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class XMLLoader {

    private ParseAccountsToList accounts;
    private ParseAccountsToList testAccounts;
    private ParseSendersToList senders;

    public void load(String xmlFileName) {

        try {
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList accountNodes = document.getElementsByTagName("account");
            NodeList testAccountNodes = document.getElementsByTagName("test_account");
            NodeList senderNodes = document.getElementsByTagName("sender");


            testAccounts = new ParseAccountsToList(testAccountNodes);
            testAccounts.start();
            accounts = new ParseAccountsToList(accountNodes);
            senders = new ParseSendersToList(senderNodes, accounts);
            senders.start();
            senders.join();
            testAccounts.join();

        } catch (ParserConfigurationException | SAXException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAccounts(){
        return  accounts.getAccounts();
    }

    public List<Sender> getSenders(){
        return  senders.getSenders();
    }

    public List<Account> getTestAccount(){
        return testAccounts.getAccounts();
    }
}

package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.Account;
import com.epam.java.se.hw1.Sender;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParseSendersToList extends Thread {

    private final NodeList sendersNodeList;
    private  List<Account> accounts;

    private final List<Sender> workingSenders = new ArrayList<>();
    private final List<Sender> allSenders = new ArrayList<>();

    public ParseSendersToList(NodeList senders, ParseAccountsToList accountsThread) {
        Objects.requireNonNull(senders);
        System.out.println(senders.getLength());
        Objects.requireNonNull(accountsThread);
        this.sendersNodeList = senders;
        accountsThread.start();
        try {
            accountsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accounts = accountsThread.getAccounts();
    }

    public ParseSendersToList(NodeList sendersNodeList, List<Account> accounts){
        Objects.requireNonNull(sendersNodeList);
        if (sendersNodeList.getLength() == 0){
            throw new IllegalArgumentException();
        }
        Objects.requireNonNull(accounts);
        if (accounts.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.sendersNodeList = sendersNodeList;
        this.accounts = accounts;
    }

    @Override
    public void run() {
        parseSendersToList();
    }


    public List<Sender> getSenders(){
        return workingSenders;
    }


    private List<Sender> parseSendersToList() {

        fillTheSenders();
        for (int i = 0; i < sendersNodeList.getLength(); i++) {
            Node node = sendersNodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                Integer senderId = Integer.valueOf(element.getAttribute("id"));
                Integer receiverId = Integer.valueOf(element.getElementsByTagName("id").item(0).getTextContent());
                Long transferAmount = Long.valueOf(element.getElementsByTagName("amount").item(0).getTextContent());

                Sender  sender  = getSenderById(senderId);
                if (sender == null){
                    continue;
                }
                Account receiver = getReceiverById(receiverId);
                if (receiver == null){
                    continue;
                }
                if (!workingSenders.contains(sender)){
                    sender.addNewReceiverAndHisOperation(receiver, transferAmount);
                    workingSenders.add(sender);
                }
                else if (sender.containsReceiver(receiver)){
                    sender.addOperationsForAccount(receiver, transferAmount);
                }
                else {
                    sender.addNewReceiverAndHisOperation(receiver, transferAmount);
                }

            }
        }
        return workingSenders;
    }

    private void fillTheSenders(){
        for (Account account : accounts) {
            allSenders.add(new Sender(account));
        }
    }

    private Sender getSenderById(Integer id){
        Sender aSender = null;
        for (Sender sender :allSenders) {
            if (sender.getId().equals(id)){
                return sender;
            }
        }
        return aSender;
    }

    private Account getReceiverById(Integer id){
        Account anAccount = null;
        for (Account account : accounts) {
            if (account.getId().equals(id)){
                return account;
            }
        }
        return anAccount;
    }
}

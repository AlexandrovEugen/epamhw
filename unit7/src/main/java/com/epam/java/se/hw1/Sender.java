package com.epam.java.se.hw1;


import com.epam.java.se.hw1.Account;

import java.util.*;

public class Sender {


    private final Account account;
    private final Map<Account, List<Long>> accountsOperations;

    public Sender(Account account) {
        Objects.requireNonNull(account);
        this.account = account;
        accountsOperations = new HashMap<>();
    }

    public void addOperationsForAccount(Account account, Long transferAmount){
        Objects.requireNonNull(account);
        Objects.requireNonNull(transferAmount);
        if (transferAmount.compareTo(0L) < 0){
            throw new IllegalArgumentException();
        }
        accountsOperations.get(account).add(transferAmount);
    }

    public void addNewReceiverAndHisOperation(Account account, Long transferAmount){
        Objects.requireNonNull(account);
        Objects.requireNonNull(transferAmount);
        if (transferAmount.compareTo(0L) < 0){
            throw new IllegalArgumentException();
        }
        List<Long> amount = Collections.singletonList(transferAmount);
        accountsOperations.put(account, amount);
    }

    public Map<Account, List<Long>> getAccountsOperations() {
        return accountsOperations;
    }

    public boolean containsReceiver(Account account){
        return accountsOperations.keySet().contains(account);
    }

    public Account getAccount() {
        return account;
    }

    public Integer getId() {
        return account.getId();
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Sender sender = (Sender) obj;
//        mapsEqual(sender.accountsOperations);
//        return this.account.equals(sender.getAccount());
//    }
//
//    @Override
//    public int hashCode() {
//        int result = account.hashCode();
//        result = 13 * result + accountsOperations.hashCode();
//        return result;
//    }
//
//    private boolean mapsEqual(Map<Account, List<Long>> attributes)
//    {
//        if (this.accountsOperations.keySet().size() != attributes.keySet().size() ||
//                this.accountsOperations.values().size() != attributes.values().size())
//            return false;
//        for (Account account : attributes.keySet()) {
//            if (!this.accountsOperations.keySet().contains(account)) {
//                return false;
//            }
//            for (Long amount : this.accountsOperations.get(account)) {
//                if (!attributes.get(account).contains(amount)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}

package com.abc.model;

import com.abc.model.types.AccountType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amgad on 26-Oct-16.
 */
public class Account {
    private double totalAmount;
    private AccountType type;
    private List<Transaction> transactionList;

    public Account(){
        setTotalAmount(0);
        setType(null);
        setTransactionList(new ArrayList<Transaction>());
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

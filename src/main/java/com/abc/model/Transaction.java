package com.abc.model;

import com.abc.model.types.TransactionType;

import java.util.Date;

/**
 * Created by amgad on 26-Oct-16.
 */
public class Transaction {
    private TransactionType type;
    private String notes;
    private double amount;
    private double accountTotalAmountBefore;
    private double accountTotalAmountAfter;
    private Date date;

    public Transaction(){
        type = null;
        notes = "";
        amount = 0;
        accountTotalAmountBefore = 0;
        accountTotalAmountAfter = 0;
        date = new Date();

    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAccountTotalAmountBefore() {
        return accountTotalAmountBefore;
    }

    public void setAccountTotalAmountBefore(double accountTotalAmountBefore) {
        this.accountTotalAmountBefore = accountTotalAmountBefore;
    }

    public double getAccountTotalAmountAfter() {
        return accountTotalAmountAfter;
    }

    public void setAccountTotalAmountAfter(double accountTotalAmountAfter) {
        this.accountTotalAmountAfter = accountTotalAmountAfter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package com.abc.operations;

import com.abc.model.Account;
import com.abc.model.Customer;

/**
 * Created by amgad on 26-Oct-16.
 */
public interface CustomerOperations {
    public Customer openAccount (Customer customer, double amount);
    public Customer deposit (Customer customer, Account account, double amount);
    public Customer withdraw (Customer customer, Account account, double amount);
    public Customer closeAccount (Customer customer, Account account, double amount);
    public Customer checkBalance (Customer customer, Account account, double amount);
    public Customer Transfer (Customer customer, Account accountFrom, Account accountTo, double amount);
    public Customer calculateDailyInterest (Customer customer, Account account, double amount);
    public Customer calculateAnnualInterest (Customer customer, Account account, double amount);
    public Customer getDetailedStatement (Customer customer, Account account, double amount);
    public double getTotalPaidInterest (Customer customer);
}

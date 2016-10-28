package com.abc.impl;

import com.abc.model.Account;
import com.abc.model.Customer;
import com.abc.model.Transaction;
import com.abc.model.types.AccountType;
import com.abc.model.types.TransactionType;
import com.abc.operations.AccountOperations;
import com.abc.operations.CustomerOperations;
import com.abc.util.BankSafeMathOperations;
import com.abc.util.PrintUtil;

/**
 * Created by amgad on 26-Oct-16.
 */
public class AbcBankCustomerOperations implements CustomerOperations {

    public Customer openAccount(Customer customer, AccountType type, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.OPENING);
        transaction.setAmount(amount);

        Account account = new Account();
        account.setType(type);

        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().add( accountOperations.process(account,transaction));
        return customer;
    }

    public Customer deposit(Customer customer, Account account, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setAmount(amount);
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().set(customer.getAccountList().indexOf(account) ,accountOperations.process(account,transaction));
        return customer;
    }

    public Customer withdraw(Customer customer, Account account, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.WITHDRAW);
        transaction.setAmount(amount);
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().set(customer.getAccountList().indexOf(account) ,accountOperations.process(account,transaction));
        return customer;
    }

    public Customer closeAccount(Customer customer, Account account, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.CLOSING);
        transaction.setAmount(amount);
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().set(customer.getAccountList().indexOf(account) ,accountOperations.process(account,transaction));

        return customer;
    }

    public Customer checkBalance(Customer customer, Account account, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.CHECK_BALANCE);
        transaction.setAmount(amount);
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().set(customer.getAccountList().indexOf(account) ,accountOperations.process(account,transaction));
        return customer;
    }

    public Customer transfer(Customer customer, Account accountFrom, Account accountTo, double amount) {
        Transaction transactionFrom = new Transaction();
        transactionFrom.setType(TransactionType.TRANSFER_FROM);
        transactionFrom.setAmount(amount);

        Transaction transactionTo = new Transaction();
        transactionTo.setType(TransactionType.TRANSFER_TO);
        transactionTo.setAmount(amount);

        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().set(customer.getAccountList().indexOf(accountFrom) ,accountOperations.process(accountFrom,transactionFrom));
        customer.getAccountList().set(customer.getAccountList().indexOf(accountTo) ,accountOperations.process(accountTo,transactionTo));

        return customer;
    }

    public Customer calculateDailyInterest(Customer customer, Account account, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.DAILY_INTEREST);
        transaction.setAmount(amount);
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().set(customer.getAccountList().indexOf(account) ,accountOperations.process(account,transaction));
        return customer;
    }

    public Customer calculateAnnualInterest(Customer customer, Account account, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.ANNUAL_INTEREST);
        transaction.setAmount(amount);
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        customer.getAccountList().set(customer.getAccountList().indexOf(account) ,accountOperations.process(account,transaction));
        return customer;
    }

    public String getDetailedStatement(Customer customer, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.DETAILED_STATEMENT);
        transaction.setAmount(amount);
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        StringBuffer result = new StringBuffer("Statement for " + customer.getName() + "\n");
        double total = 0;
        for (Account account : customer.getAccountList()) {
            result.append("\n" + accountOperations.getDetailedStatementReport(account) + "\n");
            BankSafeMathOperations.add(total,account.getTotalAmount());
        }
        result.append("\nTotal In All Accounts " + PrintUtil.toDollars(total));
        return result.toString();
    }

    public double getTotalPaidInterest (Customer customer){
        double totalInterest = 0;
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        for(Account account:customer.getAccountList()){
            totalInterest += accountOperations.getTotalInterestPaid(account);
        }
        return totalInterest;
    }

    public String getDetailedStatementReport(Customer customer){
        StringBuffer report = new StringBuffer("Statement for ");
        report.append(customer.getName());
        report.append("\n");
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        for (Account account:customer.getAccountList()){
            report.append(accountOperations.getDetailedStatementReport(account));
            report.append("\n");
        }
        return report.toString();
    }
}

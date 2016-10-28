package com.abc.impl;

import com.abc.model.Account;
import com.abc.model.Customer;
import com.abc.model.Transaction;
import com.abc.model.types.AccountType;
import com.abc.model.types.TransactionType;
import com.abc.operations.CustomerOperations;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by amgad on 28-Oct-16.
 */
public class AbcBankCustomerOperationsTest {

    @Test
    public void openAccountTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.openAccount(amgad, AccountType.SAVINGS,100);

        Assert.assertEquals(1 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(100 , amgad.getAccountList().get(0).getTotalAmount(),0.0001);
    }

    @Test
    public void depositTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account account = new Account();
        account.setType(AccountType.CHECKING);
        amgad.getAccountList().add(account);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.deposit(amgad, account,100);

        Assert.assertEquals(1 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(100 , amgad.getAccountList().get(0).getTotalAmount(),0.0001);
    }

    @Test
    public void withdrawTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account account = new Account();
        account.setType(AccountType.CHECKING);
        account.setTotalAmount(1000);
        amgad.getAccountList().add(account);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.withdraw(amgad, account,100);

        Assert.assertEquals(1 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(900 , amgad.getAccountList().get(0).getTotalAmount(),0.0001);
    }

    @Test
    public void closeAccountTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account account = new Account();
        account.setType(AccountType.CHECKING);
        account.setTotalAmount(100);
        amgad.getAccountList().add(account);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.closeAccount(amgad, account,100);

        Assert.assertEquals(1 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(0 , amgad.getAccountList().get(0).getTotalAmount(),0.0001);
    }

    @Test
    public void checkBalanceTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account account = new Account();
        account.setType(AccountType.CHECKING);
        account.setTotalAmount(100);
        amgad.getAccountList().add(account);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.checkBalance(amgad, account,1);

        Assert.assertEquals(1 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(99, amgad.getAccountList().get(0).getTotalAmount(),0.0001);
    }

    @Test
    public void TransferTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account accountTo = new Account();
        accountTo.setType(AccountType.CHECKING);
        accountTo.setTotalAmount(100);
        amgad.getAccountList().add(accountTo);

        Account accountFrom = new Account();
        accountFrom.setType(AccountType.CHECKING);
        accountFrom.setTotalAmount(300);
        amgad.getAccountList().add(accountFrom);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.transfer(amgad, accountFrom,accountTo,100);

        Assert.assertEquals(2 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(200 , amgad.getAccountList().get(0).getTotalAmount(),0.0001);
        Assert.assertEquals(200 , amgad.getAccountList().get(1).getTotalAmount(),0.0001);
    }

    @Test
    public void calculateDailyInterestTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account account = new Account();
        account.setType(AccountType.CHECKING);
        account.setTotalAmount(1000);
        amgad.getAccountList().add(account);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.calculateDailyInterest(amgad, account,1);

        Assert.assertEquals(1 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(1001 , amgad.getAccountList().get(0).getTotalAmount(),0.0001);
    }

    @Test
    public void calculateAnnualInterestTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account account = new Account();
        account.setType(AccountType.CHECKING);
        account.setTotalAmount(1000);
        amgad.getAccountList().add(account);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        customerOperations.calculateDailyInterest(amgad, account,10);

        Assert.assertEquals(1 , amgad.getAccountList().size());
        Assert.assertEquals(1 , amgad.getAccountList().get(0).getTransactionList().size());
        Assert.assertEquals(1010 , amgad.getAccountList().get(0).getTotalAmount(),0.0001);
    }

    @Test
    public void getDetailedStatementTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        Account account = new Account();
        account.setTotalAmount(100);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(10);
        transaction.setType(TransactionType.OPENING);
        account.getTransactionList().add(transaction);

        transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.DEPOSIT);
        account.getTransactionList().add(transaction);

        transaction = new Transaction();
        transaction.setAmount(1);
        transaction.setType(TransactionType.DAILY_INTEREST);
        account.getTransactionList().add(transaction);

        transaction = new Transaction();
        transaction.setAmount(5);
        transaction.setType(TransactionType.ANNUAL_INTEREST);
        account.getTransactionList().add(transaction);

        amgad.getAccountList().add(account);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        String actual = customerOperations.getDetailedStatement(amgad,0);

        StringBuffer expected = new StringBuffer("Statement for Amgad Atef\n\n");
        expected.append("Checking Account \n");
        expected.append("OPENING $10.00\n");
        expected.append("DEPOSIT $100.00\n");
        expected.append("DAILY_INTEREST $1.00\n");
        expected.append("ANNUAL_INTEREST $5.00\n");
        expected.append("Total $100.00\n\n");
        expected.append("Total In All Accounts $0.00");

        Assert.assertEquals(expected.toString(),actual);
    }

    @Test
    public void getTotalPaidInterestTest (){
        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");

        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);
        amgad.getAccountList().add(account);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.DAILY_INTEREST);
        account.getTransactionList().add(transaction);

        account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);
        amgad.getAccountList().add(account);

        transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.DAILY_INTEREST);
        account.getTransactionList().add(transaction);

        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        double totalInterest = customerOperations.getTotalPaidInterest(amgad);

        Assert.assertEquals(200,totalInterest,0.0001);
    }
}

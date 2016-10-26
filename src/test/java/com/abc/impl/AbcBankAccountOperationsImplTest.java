package com.abc.impl;

import com.abc.model.Account;
import com.abc.model.Transaction;
import com.abc.model.types.AccountType;
import com.abc.model.types.TransactionType;
import com.abc.operations.AccountOperations;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by amgad on 26-Oct-16.
 */
public class AbcBankAccountOperationsImplTest {

    // opening account with balance
    @Test
    public void openAcountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.OPENING);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(100,result.getTotalAmount(),0.0001);
    }

    // opening account without balance
    @Test
    public void openAcountWithoutAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(0);
        transaction.setType(TransactionType.OPENING);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(0,result.getTotalAmount(),0.0001);
    }

    // OPENING account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void openAcountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.OPENING);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }


    // DEPOSIT account with balance
    @Test
    public void depositAcountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.DEPOSIT);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(100,result.getTotalAmount(),0.0001);
    }

    // DEPOSIT account without balance
    @Test
    public void depositAcountWithoutAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(0);
        transaction.setType(TransactionType.DEPOSIT);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(0,result.getTotalAmount(),0.0001);
    }

    // DEPOSIT account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void depositAcountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.DEPOSIT);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }


    // DAILY_INTEREST account with balance
    @Test
    public void dailyInterestAcountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.DAILY_INTEREST);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(100,result.getTotalAmount(),0.0001);
    }

    // DAILY_INTEREST account without balance
    @Test
    public void dailyInterestAcountWithoutAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(0);
        transaction.setType(TransactionType.DAILY_INTEREST);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(0,result.getTotalAmount(),0.0001);
    }

    // DAILY_INTEREST account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void dailyInterestAcountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.DAILY_INTEREST);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }


    // ANNUAL_INTEREST account with balance
    @Test
    public void annualInterestAcountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.ANNUAL_INTEREST);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(100,result.getTotalAmount(),0.0001);
    }

    // ANNUAL_INTEREST account without balance
    @Test
    public void annualInterestAcountWithoutAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(0);
        transaction.setType(TransactionType.ANNUAL_INTEREST);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(0,result.getTotalAmount(),0.0001);
    }

    // ANNUAL_INTEREST account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void annualInterestAcountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.ANNUAL_INTEREST);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }


    // TRANSFER_TO account with balance
    @Test
    public void transferToAcountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.TRANSFER_TO);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(100,result.getTotalAmount(),0.0001);
    }

    // TRANSFER_TO account without balance
    @Test
    public void transferToAcountWithoutAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(0);
        transaction.setType(TransactionType.TRANSFER_TO);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(0,result.getTotalAmount(),0.0001);
    }

    // TRANSFER_TO account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void transferToAcountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.WITHDRAW);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }


    @Test
    public void withdrawWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.WITHDRAW);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(900,result.getTotalAmount(),0.0001);
    }

    // opening account with balance
    @Test(expected=IllegalArgumentException.class)
    public void withdrawWithoutAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-100);
        transaction.setType(TransactionType.WITHDRAW);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

    }
}

package com.abc.impl;

import com.abc.model.Account;
import com.abc.model.Transaction;
import com.abc.model.types.AccountType;
import com.abc.model.types.TransactionType;
import com.abc.operations.AccountOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by amgad on 26-Oct-16.
 */
public class AbcBankAccountOperationsImplTest {

    // opening account with balance
    @Test
    public void openAccountWithAmountTest(){
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
    public void openAccountWithoutAmountTest(){
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
    public void openAccountWithNegativeAmountTest(){
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
    public void depositAccountWithAmountTest(){
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
    public void depositAccountWithoutAmountTest(){
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
    public void depositAccountWithNegativeAmountTest(){
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
    public void dailyInterestAccountWithAmountTest(){
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
    public void dailyInterestAccountWithoutAmountTest(){
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
    public void dailyInterestAccountWithNegativeAmountTest(){
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
    public void annualInterestAccountWithAmountTest(){
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
    public void annualInterestAccountWithoutAmountTest(){
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
    public void annualInterestAccountWithNegativeAmountTest(){
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
    public void transferToAccountWithAmountTest(){
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
    public void transferToAccountWithoutAmountTest(){
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
    public void transferToAccountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.TRANSFER_TO);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // WITHDRAW account with no balance
    @Test(expected=IllegalArgumentException.class)
    public void withdrawAccountWithNoAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.WITHDRAW);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // WITHDRAW account with balance
    @Test
    public void withdrawAccountWithAmountTest(){
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

    // WITHDRAW account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void withdrawAccountWithNegativeAmountTest(){
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

    // CHECK_BALANCE account with no balance
    @Test(expected=IllegalArgumentException.class)
    public void checkBalanceAccountWithNoAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.CHECK_BALANCE);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // CHECK_BALANCE account with balance
    @Test
    public void checkBalanceAccountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.CHECK_BALANCE);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(900,result.getTotalAmount(),0.0001);
    }

    // CHECK_BALANCE account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void checkBalanceAccountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.CHECK_BALANCE);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // DETAILED_STATEMENT account with no balance
    @Test(expected=IllegalArgumentException.class)
    public void checkDetailedBalanceAccountWithNoAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.DETAILED_STATEMENT);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // DETAILED_STATEMENT account with balance
    @Test
    public void checkDetailedBalanceAccountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.DETAILED_STATEMENT);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(900,result.getTotalAmount(),0.0001);
    }

    // DETAILED_STATEMENT account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void checkDetailedBalanceAccountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.DETAILED_STATEMENT);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // TRANSFER_FROM account with no balance
    @Test(expected=IllegalArgumentException.class)
    public void transferFromAccountWithNoAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.TRANSFER_FROM);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // TRANSFER_FROM account with balance
    @Test
    public void transferFromAccountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setType(TransactionType.TRANSFER_FROM);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(900,result.getTotalAmount(),0.0001);
    }

    // TRANSFER_FROM account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void transferFromAccountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.TRANSFER_FROM);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // CLOSING account with balance
    @Test
    public void closeAccountWithAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(1000);
        transaction.setType(TransactionType.CLOSING);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);

        Assert.assertEquals(0,result.getTotalAmount(),0.0001);
    }

    // CLOSING account with negative amount
    @Test(expected=IllegalArgumentException.class)
    public void closeAccountWithNegativeAmountTest(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(0);
        account.setType(AccountType.CHECKING);

        Transaction transaction = new Transaction();
        transaction.setAmount(-1);
        transaction.setType(TransactionType.CLOSING);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.process(account,transaction);
    }

    // Test getting total paid interest from transactions list
    @Test
    public void getTotalInterestPaidTest(){
        //Prepare for Data
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

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        double totalInterest = accountOperations.getTotalInterestPaid(account);

        Assert.assertEquals(6,totalInterest,0.0001);
    }

    // calculate Interest Checking
    @Test
    public void calculateInterestTestChecking(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000000);
        account.setType(AccountType.CHECKING);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.calculateInterest(account);

        Assert.assertEquals(1000002.7322404372,result.getTotalAmount(),0.0001);
    }

    // calculate Interest Savings GreaterThan Thousand
    @Test
    public void calculateInterestTestSavings(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.SAVINGS);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.calculateInterest(account);

        Assert.assertEquals(1000.0027322404371,result.getTotalAmount(),0.0001);
    }

    // calculate Interest Savings GreaterThan Thousand
    @Test
    public void calculateInterestTestSavingsGreaterThanThousand(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000000);
        account.setType(AccountType.SAVINGS);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.calculateInterest(account);

        Assert.assertEquals(1000002.7322404372,result.getTotalAmount(),0.0001);
    }

    // calculate Interest MaxiSavings No Withdrawal
    @Test
    public void calculateInterestTestMaxiSavingsNoWithdrawal(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.MAXI_SAVINGS);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.calculateInterest(account);

        Assert.assertEquals(1000.1366120218579,result.getTotalAmount(),0.0001);
    }

    // calculate Interest MaxiSavings
    @Test
    public void calculateInterestTestMaxiSavings(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.MAXI_SAVINGS);

        Transaction transaction = new Transaction();
        transaction.setAmount(10);
        transaction.setType(TransactionType.WITHDRAW);

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -5);
        Date fiveDaysAgo = cal.getTime();
        transaction.setDate(fiveDaysAgo);
        account.getTransactionList().add(transaction);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        Account result = accountOperations.calculateInterest(account);

        Assert.assertEquals(1000.0027322404371,result.getTotalAmount(),0.0001);
    }

    @Test
    public void noWithdrawalsLastTenDaysTestFalse(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.MAXI_SAVINGS);

        Transaction transaction = new Transaction();
        transaction.setAmount(10);
        transaction.setType(TransactionType.WITHDRAW);

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -5);
        Date fiveDaysAgo = cal.getTime();
        transaction.setDate(fiveDaysAgo);
        account.getTransactionList().add(transaction);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        boolean result = accountOperations.noWithdrawalsLastTenDays(account);

        Assert.assertEquals(false,result);
    }

    @Test
    public void noWithdrawalsLastTenDaysTestTrue(){
        //Prepare for Data
        Account account = new Account();
        account.setTotalAmount(1000);
        account.setType(AccountType.MAXI_SAVINGS);

        Transaction transaction = new Transaction();
        transaction.setAmount(10);
        transaction.setType(TransactionType.WITHDRAW);

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -11);
        Date fiveDaysAgo = cal.getTime();
        transaction.setDate(fiveDaysAgo);
        account.getTransactionList().add(transaction);

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        boolean result = accountOperations.noWithdrawalsLastTenDays(account);

        Assert.assertEquals(true,result);
    }

    @Test
    public void getDetailedStatementReportTest(){
        //Prepare for Data
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

        //call function
        AccountOperations accountOperations = new AbcBankAccountOperationsImpl();
        String result = accountOperations.getDetailedStatementReport(account);

        StringBuffer expected = new StringBuffer("Checking Account \n");
        expected.append("OPENING $10.00\n");
        expected.append("DEPOSIT $100.00\n");
        expected.append("DAILY_INTEREST $1.00\n");
        expected.append("ANNUAL_INTEREST $5.00\n");
        expected.append("Total $100.00");

        Assert.assertEquals(expected.toString(),result);
    }
}

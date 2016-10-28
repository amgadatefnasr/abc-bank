package com.abc.impl;

import com.abc.model.Account;
import com.abc.model.Bank;
import com.abc.model.Customer;
import com.abc.model.Transaction;
import com.abc.model.types.AccountType;
import com.abc.model.types.TransactionType;
import com.abc.operations.BankOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by amgad on 28-Oct-16.
 */
public class AbcBankBankOperationsImplTest {

    @Test
    public void getCustomerList(){

        Bank bank = new Bank();
        Customer customer = new Customer();
        bank.getCustomerList().add(customer);

        customer = new Customer();
        bank.getCustomerList().add(customer);

        BankOperations bankOperations = new AbcBankBankOperationsImpl();
        List<Customer> customerList = bankOperations.getCustomerList(bank);
        Assert.assertEquals(2,customerList.size());

    }

    @Test
    public void addCustomer(){

        Bank bank = new Bank();
        Customer customer = new Customer();
        bank.getCustomerList().add(customer);

        BankOperations bankOperations = new AbcBankBankOperationsImpl();
        customer = new Customer();
        Bank result= bankOperations.addCustomer(bank,customer);

        Assert.assertEquals(2,result.getCustomerList().size());

    }

    @Test
    public void updateCustomer(){
        Bank bank = new Bank();
        Customer customer = new Customer();
        customer.setName("Amgad");
        bank.getCustomerList().add(customer);

        BankOperations bankOperations = new AbcBankBankOperationsImpl();
        Customer newCustomer = new Customer();
        newCustomer.setName("Amgad Atef");
        Bank result= bankOperations.updateCustomer(bank,customer,newCustomer);

        Assert.assertEquals(1,result.getCustomerList().size());
        Assert.assertEquals("Amgad Atef",result.getCustomerList().get(0).getName());

    }

    @Test
    public void getCustomerSummary(){
        Bank bank = new Bank();
        Customer customer = new Customer();
        customer.setName("Amgad");
        bank.getCustomerList().add(customer);

        BankOperations bankOperations = new AbcBankBankOperationsImpl();
        String result = bankOperations.getCustomerSummary(bank);

        String expected = "Customer Summary\n" +
                " - Amgad (0 account)";

        Assert.assertEquals(expected,result);
    }

    @Test
    public void getTotalPaidInterest(){
        Bank bank = new Bank();

        Customer amgad = new Customer();
        amgad.setId("123");
        amgad.setName("Amgad Atef");
        bank.getCustomerList().add(amgad);

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

        BankOperations bankOperations = new AbcBankBankOperationsImpl();
        double totalInterest = bankOperations.getTotalPaidInterest(bank);

        Assert.assertEquals(200,totalInterest,0.0001);
    }
}

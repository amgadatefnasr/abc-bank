package com.abc.impl;

import com.abc.model.Bank;
import com.abc.model.Customer;
import com.abc.operations.BankOperations;
import com.abc.operations.CustomerOperations;
import com.abc.util.PrintUtil;

import java.util.List;

/**
 * Created by amgad on 26-Oct-16.
 */
public class AbcBankBankOperationsImpl implements BankOperations {
    public List<Customer> getCustomerList(Bank bank){
        return bank.getCustomerList();
    }
    public Bank addCustomer(Bank bank,Customer customer){
        bank.getCustomerList().add(customer);
        return bank;
    }
    public Bank updateCustomer(Bank bank, Customer customer, Customer updatedCustomer){
        bank.getCustomerList().set(bank.getCustomerList().indexOf(customer), updatedCustomer);
        return bank;
    }
    public String getCustomerSummary(Bank bank){
        StringBuffer summary = new StringBuffer("Customer Summary");
        for(Customer customer : bank.getCustomerList()){
            summary.append( "\n - " + customer.getName() + " (" + PrintUtil.formatWord(customer.getAccountList().size(), "account") + ")");
        }
        return summary.toString();
    }
    public double getTotalPaidInterest(Bank bank){
        double totalInterest = 0 ;
        CustomerOperations customerOperations = new AbcBankCustomerOperations();
        for(Customer customer:bank.getCustomerList()){
            totalInterest += customerOperations.getTotalPaidInterest(customer);
        }
        return totalInterest;
    }
}

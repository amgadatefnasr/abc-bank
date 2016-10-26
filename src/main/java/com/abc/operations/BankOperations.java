package com.abc.operations;

import com.abc.model.Bank;
import com.abc.model.Customer;

import java.util.List;

/**
 * Created by amgad on 26-Oct-16.
 */
public interface BankOperations {
    public List<Customer> getCustomerList(Bank bank);
    public Bank addCustomer(Bank bank, Customer customer);
    public Bank updateCustomer(Bank bank, Customer customer, Customer updatedCustomer);
    public String getCustomerSummary(Bank bank);
    public double getTotalPaidInterest(Bank bank);
}

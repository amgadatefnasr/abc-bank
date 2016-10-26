package com.abc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amgad on 26-Oct-16.
 */
public class Bank {
    private List<Customer> customerList;

    public Bank(){
        setCustomerList(new ArrayList<Customer>());
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

package com.abc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amgad on 26-Oct-16.
 */
public class Customer {
    private String id;
    private String name;
    private List<Account> accountList;

    public Customer(){
        id = "";
        name = "";
        accountList = new ArrayList<Account>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}

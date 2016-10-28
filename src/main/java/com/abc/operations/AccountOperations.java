package com.abc.operations;

import com.abc.model.Account;
import com.abc.model.Transaction;

/**
 * Created by amgad on 26-Oct-16.
 */
public interface AccountOperations {
    public Account process(Account a, Transaction t);
    public double getTotalInterestPaid(Account a);
    public boolean noWithdrawalsLastTenDays(Account a);
    public Account calculateInterest(Account a);
    public String getDetailedStatementReport(Account a);
}

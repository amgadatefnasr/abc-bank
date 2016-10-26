package com.abc.impl;

import com.abc.constants.AbcBankInterestRates;
import com.abc.model.Account;
import com.abc.model.Transaction;
import com.abc.model.types.TransactionType;
import com.abc.operations.AccountOperations;
import com.abc.util.BankSafeMathOperations;
import com.abc.util.CalendarUtil;
import com.abc.util.PrintUtil;

import java.util.Date;

/**
 * Created by amgad on 26-Oct-16.
 */
public class AbcBankAccountOperationsImpl implements AccountOperations {
    public Account process(Account account, Transaction transaction) {
        transaction.setAccountTotalAmountBefore(account.getTotalAmount());
        switch(transaction.getType()){
            case OPENING:
                account.setTotalAmount(BankSafeMathOperations.add(account.getTotalAmount(),transaction.getAmount()));
                break;
            case DEPOSIT:
                account.setTotalAmount(BankSafeMathOperations.add(account.getTotalAmount(),transaction.getAmount()));
                break;
            case WITHDRAW:
                account.setTotalAmount(BankSafeMathOperations.subtract(account.getTotalAmount(),transaction.getAmount()));
                break;
            case CHECK_BALANCE:
                account.setTotalAmount(BankSafeMathOperations.subtract(account.getTotalAmount(),transaction.getAmount()));
                break;
            case DETAILED_STATEMENT:
                account.setTotalAmount(BankSafeMathOperations.subtract(account.getTotalAmount(),transaction.getAmount()));
                break;
            case DAILY_INTEREST:
                account.setTotalAmount(BankSafeMathOperations.add(account.getTotalAmount(),transaction.getAmount()));
                break;
            case ANNUAL_INTEREST:
                account.setTotalAmount(BankSafeMathOperations.add(account.getTotalAmount(),transaction.getAmount()));
                break;
            case TRANSFER_FROM:
                account.setTotalAmount(BankSafeMathOperations.subtract(account.getTotalAmount(),transaction.getAmount()));
                break;
            case TRANSFER_TO:
                account.setTotalAmount(BankSafeMathOperations.add(account.getTotalAmount(),transaction.getAmount()));
                break;
            case CLOSING:
                account.setTotalAmount(BankSafeMathOperations.subtract(account.getTotalAmount(),transaction.getAmount()));
                break;
        }
        transaction.setAccountTotalAmountAfter(account.getTotalAmount());
        account.getTransactionList().add(transaction);
        return account;
    }

    public double getTotalInterestPaid(Account account){
        double totalInterest = 0;
        for(Transaction transaction : account.getTransactionList()){
            if(transaction.getType() == TransactionType.DAILY_INTEREST ||
                    transaction.getType() == TransactionType.ANNUAL_INTEREST ){
                totalInterest += transaction.getAmount();
            }
        }
        return totalInterest;
    }

    public boolean noWithdrawalsLastTenDays(Account account){
        for(Transaction transaction : account.getTransactionList()){
            if(transaction.getType() == TransactionType.WITHDRAW
                    && transaction.getDate().before(new Date())
                    && transaction.getDate().after(CalendarUtil.dateTenDaysAgo()))
                return false;
        }
        return true;
    }

    public String getDetailedStatementReport(Account account){
        StringBuffer report = new StringBuffer("");
        switch (account.getType()){
            case CHECKING:
                report.append("Checking Account \n");
                break;
            case SAVINGS:
                report.append("Savings Account \n");
                break;
            case MAXI_SAVINGS:
                report.append("Maxi Savings Account \n");
                break;
        }
        for(Transaction transaction:account.getTransactionList()){
            switch (transaction.getType()){
                case OPENING:
                    report.append("OPENING " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case DEPOSIT:
                    report.append("DEPOSIT " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case WITHDRAW:
                    report.append("WITHDRAW " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case TRANSFER_FROM:
                    report.append("TRANSFER_FROM " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case TRANSFER_TO:
                    report.append("TRANSFER_TO " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case CHECK_BALANCE:
                    report.append("CHECK_BALANCE " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case DETAILED_STATEMENT:
                    report.append("DETAILED_STATEMENT " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case DAILY_INTEREST:
                    report.append("DAILY_INTEREST " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case ANNUAL_INTEREST:
                    report.append("ANNUAL_INTEREST " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
                case CLOSING:
                    report.append("CLOSING " + PrintUtil.toDollars(transaction.getAmount()) + "\n");
                    break;
            }
        }
        report.append("Total " + PrintUtil.toDollars(account.getTotalAmount()));
        return report.toString();
    }

    public Account calculateInterest(Account account){
        Transaction transaction = null;
        double totalInterest = 0;
        switch (account.getType()){
            case CHECKING:
                    totalInterest = BankSafeMathOperations.multiply(account.getTotalAmount(), AbcBankInterestRates.pointOnePercent);
                    totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                    transaction = new Transaction();
                    transaction.setType(TransactionType.DAILY_INTEREST);
                    transaction.setAmount(totalInterest);
                    account = process(account,transaction);
                break;
            case SAVINGS:
                    if(account.getTotalAmount()<=1000){
                        totalInterest = BankSafeMathOperations.multiply(account.getTotalAmount(),AbcBankInterestRates.pointOnePercent);
                        totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                        transaction = new Transaction();
                        transaction.setType(TransactionType.DAILY_INTEREST);
                        transaction.setAmount(totalInterest);
                        account = process(account,transaction);
                    }else{
                        totalInterest = 0;
                        totalInterest += BankSafeMathOperations.multiply(1000,AbcBankInterestRates.pointOnePercent);
                        totalInterest += BankSafeMathOperations.multiply((account.getTotalAmount()-1000),AbcBankInterestRates.pointOnePercent);
                        totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                        transaction = new Transaction();
                        transaction.setType(TransactionType.DAILY_INTEREST);
                        transaction.setAmount(totalInterest);
                        account = process(account,transaction);
                    }
                break;
            case MAXI_SAVINGS:
                /*
                 *  Old Calculation
                 */
                /*if(account.getTotalAmount()<=1000){
                    double totalInterest = BankSafeMathOperations.multiply(account.getTotalAmount(),AbcBankInterestRates.twoPercent);
                    totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                    transaction = new Transaction();
                    transaction.setType(TransactionType.DAILY_INTEREST);
                    transaction.setAmount(totalInterest);
                    account = process(account,transaction);
                }else if(account.getTotalAmount()<=2000 && account.getTotalAmount() > 1000){
                    double totalInterest = 0;
                    totalInterest += BankSafeMathOperations.multiply(1000,AbcBankInterestRates.twoPercent);
                    totalInterest += BankSafeMathOperations.multiply((account.getTotalAmount()-1000),AbcBankInterestRates.fivePercent);
                    totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                    transaction = new Transaction();
                    transaction.setType(TransactionType.DAILY_INTEREST);
                    transaction.setAmount(totalInterest);
                    account = process(account,transaction);
                }else if(account.getTotalAmount() > 2000){
                    double totalInterest = 0;
                    totalInterest += BankSafeMathOperations.multiply(1000,AbcBankInterestRates.twoPercent);
                    totalInterest += BankSafeMathOperations.multiply(1000,AbcBankInterestRates.fivePercent);
                    totalInterest += BankSafeMathOperations.multiply((account.getTotalAmount()-2000),AbcBankInterestRates.fivePercent);
                    totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                    transaction = new Transaction();
                    transaction.setType(TransactionType.DAILY_INTEREST);
                    transaction.setAmount(totalInterest);
                    account = process(account,transaction);
                }*/
                if(noWithdrawalsLastTenDays(account)){
                    totalInterest = BankSafeMathOperations.multiply(account.getTotalAmount(), AbcBankInterestRates.fivePercent);
                    totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                    transaction = new Transaction();
                    transaction.setType(TransactionType.DAILY_INTEREST);
                    transaction.setAmount(totalInterest);
                    account = process(account,transaction);
                }else {
                    totalInterest = BankSafeMathOperations.multiply(account.getTotalAmount(), AbcBankInterestRates.pointOnePercent);
                    totalInterest = BankSafeMathOperations.divide(totalInterest, CalendarUtil.getNumberOfDaysInCurrentYear());

                    transaction = new Transaction();
                    transaction.setType(TransactionType.DAILY_INTEREST);
                    transaction.setAmount(totalInterest);
                    account = process(account,transaction);
                }

                break;
        }

        return account;
    }
}

package com.abc.model.types;

/*
 *  Transaction_ Types :-
 *  Opening in case the account type restrict the customer to deposit a certain amount of money to be able to open the account (opening balance)
 *  Deposit when the customer needs to put a certain amount of money in his account
 *  Withdraw when the customer needs to get a certain amount of money from his account
 *  Closing when the customer needs to close this account
 *  Check_Balance when the customer check his balance sometime there are some fees
 *  Transfer_to when a customer transferred a certain amount of money to this account (deposit)
 *  Transfer_from when a customer transferred a certain amount of money from this account (withdraw)
 *  DAILY_INTEREST daily interest is calculated and added to the account total
 *  ANNUAL_INTEREST annual interest is calculated and added to the account total
 *  DETAILED_STATEMENT when customer require a detailed statement on this account
 */
public enum TransactionType {
    OPENING, DEPOSIT, WITHDRAW, CLOSING, CHECK_BALANCE, TRANSFER_TO, TRANSFER_FROM, DAILY_INTEREST, ANNUAL_INTEREST, DETAILED_STATEMENT
}

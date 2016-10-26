package com.abc.util;

/**
 * Created by amgad on 26-Oct-16.
 */
public class BankSafeMathOperations {
    public static double add (double amountA, double amountB){
        if(amountA < 0 || amountB < 0)
            throw new IllegalArgumentException("amount must be greater than zero");
        return amountA + amountB;
    }

    public static double subtract (double amountA, double amountB){
        if(amountA < 0 || amountB < 0)
            throw new IllegalArgumentException("amount must be greater than zero");
        if(amountA < amountB)
            throw new IllegalArgumentException("invalid amount");
        return amountA - amountB;
    }

    public static double multiply (double amountA, double amountB){
        if(amountA < 0 || amountB < 0)
            throw new IllegalArgumentException("amount must be greater than zero");
        return amountA * amountB;
    }

    public static double divide (double amountA, double amountB){
        if(amountA < 0 || amountB <= 0)
            throw new IllegalArgumentException("amount must be greater than zero");
        if(amountB == 0)
            throw new IllegalArgumentException("invalid amount");
        return amountA / amountB;
    }
}

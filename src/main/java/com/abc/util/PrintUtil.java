package com.abc.util;

import static java.lang.Math.abs;

/**
 * Created by amgad on 26-Oct-16.
 */
public class PrintUtil {
    public static String formatWord(int number, String word) {
        return number + " " + (number <= 1 ? word : word + "s");
    }
    public static String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}

package com.abc.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by amgad on 26-Oct-16.
 */
public class CalendarUtil {
    public static int getNumberOfDaysInCurrentYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    public static Date dateTenDaysAgo(){
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -10);
        Date tenDaysAgo = cal.getTime();
        return tenDaysAgo;
    }
}

package com.sp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExtension {
	
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	public static Date addMonth(Date date, int months)
	{
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}
	public static Date addYear(Date date, int years)
	{
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}
}

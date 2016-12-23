package com.haikarose.codestube.tools;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by root on 8/13/16.
 */

public class TodayDateResolver {

    public static String getResolvedDate(){

        GregorianCalendar calendar=new GregorianCalendar();
        int day=calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int month=calendar.get(GregorianCalendar.MONTH)+1;
        int year=calendar.get(GregorianCalendar.YEAR);
        int hour=calendar.get(GregorianCalendar.HOUR);
        int minutes=calendar.get(GregorianCalendar.MINUTE);
        int seconds=calendar.get(GregorianCalendar.SECOND);
        int am_pm=calendar.get(GregorianCalendar.AM_PM);

        String day_name=calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
        String month_name=calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());


        String formatted_date=DateStringHelper.formatter(day)+"/"+DateStringHelper.formatter(month)+"/"+
                DateStringHelper.formatter(year)+"/"+DateStringHelper.formatter(hour)+"/"+DateStringHelper.formatter(minutes)+"/"+
                DateStringHelper.formatter(seconds)+"/"+day_name+"/"+month_name+"/"+DateStringHelper.formatter(am_pm);

        return formatted_date;
    }
}

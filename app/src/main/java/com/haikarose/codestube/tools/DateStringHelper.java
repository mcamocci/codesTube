package com.haikarose.codestube.tools;


import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 * Created by root on 8/13/16.
 */
public class DateStringHelper {

    public static String getDate(String date){


        String dateStrings=date;
        String dateString[]=dateStrings.split("/");

        String varible="";

        int re_day= Integer.parseInt(dateString[0]);
        int re_month= Integer.parseInt(dateString[1]);
        int re_year= Integer.parseInt(dateString[2]);
        int re_hour= Integer.parseInt(dateString[3]);
        int re_min= Integer.parseInt(dateString[4]);
        int re_sec= Integer.parseInt(dateString[5]);
        String day_text=dateString[6];
        String mont_text=dateString[7];
        int re_am_pm= Integer.parseInt(dateString[8]);

        GregorianCalendar calendar=new GregorianCalendar();
        int day=calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int month=calendar.get(GregorianCalendar.MONTH)+1;
        int year=calendar.get(GregorianCalendar.YEAR);
        int hour=calendar.get(GregorianCalendar.HOUR);
        int minutes=calendar.get(GregorianCalendar.MINUTE);
        int seconds=calendar.get(GregorianCalendar.SECOND);
        int am_pm=calendar.get(GregorianCalendar.AM_PM);


        if(day==re_day && month==re_month && year==re_year && hour==re_hour && minutes==re_min && seconds>=re_sec){

            if(re_am_pm==am_pm){
                varible="a moment ago";
            }else if(re_am_pm==am_pm) {
                varible="earlier today @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);

            }

        }else if(day==re_day && month==re_month && year==re_year && hour<=re_hour&&minutes>=re_min){

            int val=minutes-re_min;
            if(re_am_pm==am_pm && hour>=re_hour){
                if(val==1){
                    varible=formatter(minutes-re_min)+" minute past";
                }else{
                    varible=val>1? formatter(minutes-re_min)+" minutes ago": "few seconds ago";
                }
            }else {
                varible="earlier today @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);
            }

        }else if(day==re_day && month==re_month && year==re_year){

            if (hour-re_hour>10) {
                varible="earlier today @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);
            } else if(hour-re_hour>5) {
                varible="today @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);
            }else {

                if (re_am_pm==am_pm) {
                    varible="today @"+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);
                } else {
                    varible="earlier today @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);
                }

            }

        }else if(re_day==day-1 && month==re_month && year==re_year){

            varible="yesterday @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);

        }else{

            if (re_year!=year) {
                varible=mont_text+" "+ formatter(re_day) +", "+ formatter(re_year)+" @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);
            } else {
                varible=day_text+" "+mont_text+" "+ formatter(re_day) +" @ "+formatter(re_hour)+":"+formatter(re_min)+amOrPm(re_am_pm);
            }

        }

        return varible;
    }

    public static String formatter(int number){

        String value;
        if(number<10){
            DecimalFormat decimalFormat=new DecimalFormat("00");
            value=decimalFormat.format(number);
            return value;
        }
        return Integer.toString(number);
    }

    public static String amOrPm(int am_pm){
        if(am_pm==0){
            return "am";
        }
        return "pm";
    }
}

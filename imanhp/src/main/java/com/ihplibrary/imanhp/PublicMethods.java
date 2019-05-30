package com.ihplibrary.imanhp;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;

import java.text.DecimalFormat;

import es.dmoral.toasty.Toasty;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class PublicMethods {
    public static void Standard_Toast(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    public static void saveValue(Context mContext, String key, String value) {
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString(key, value).apply();
    }

    public static String getValue(Context mContext, String key, String def) {
        String value = PreferenceManager.getDefaultSharedPreferences(mContext).getString(key, def);
        return value;
    }

    public static void removeValue(Context mContext, String name) {
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().remove(name).apply();
    }

    public static void Custom_toast(String msg, Context mContext) {
        Toasty.error(mContext, msg, Toast.LENGTH_SHORT, false).show();

    }

    public static void animation(Animation animation, View view, Context mContext, int anim_address) {
        animation = AnimationUtils.loadAnimation(mContext, anim_address);
        view.startAnimation(animation);
    }

    public static double fahrenheit_To_centigrade(double f) {
        return (f - 32) / 1.8;
    }

    public static String convert_Shamsi_To_Miladi(int year, int month, int day) {
        String monthConvert;
        String dayConvert;
        String yearConvert;
        DateConverter converter = new DateConverter();
        converter.persianToGregorian(year, month, day);
        dayConvert = converter.getDay() + "";
        monthConvert = converter.getMonth() + "";
        yearConvert = converter.getYear() + "";
        return yearConvert + "/" + monthConvert + "/" + dayConvert;
    }

    public static String convert_Miladi_To_Shamsi(int year, int month, int day) {
        String monthConvert;
        String dayConvert;
        String yearConvert;
        DateConverter converter = new DateConverter();
        converter.gregorianToPersian(year, month, day);
        dayConvert = converter.getDay() + "";
        monthConvert = converter.getMonth() + "";
        yearConvert = converter.getYear() + "";
        return yearConvert + "/" + monthConvert + "/" + dayConvert;
    }

    public static String get_Date_Today() {
        String month;
        String year;
        String day;
        PersianCalendar pc = new PersianCalendar();
        month = pc.getPersianMonth() + "";
        year = pc.getPersianYear() + "";
        day = pc.getPersianDay() + "";
        return year + "/" + month + "/" + day;
    }

    public static String get_Time() {
        String time;
        PersianCalendar pc = new PersianCalendar();
        time = pc.getPersianShortDateTime() + "";
        return time;
    }

    public static String splitDigits(int number) {
        return new DecimalFormat("###,###,###,###").format(number);
    }

    public static String splitDigitsLong(Long number) {
        return new DecimalFormat("###,###,###,###,###").format(number);
    }

    public static String convert_Miladi_To_Hijri(int year, int month, int day) {

        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();

        LocalDate todayIso = new LocalDate(year, month, day, iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(),
                hijri);
        // 1434-05-19
        String hijriDate=String.valueOf(todayHijri);
        String[] str=hijriDate.split("-");
        int days=Integer.parseInt(str[2])+1;
        return str[0]+"/"+str[1]+"/"+days;}

}



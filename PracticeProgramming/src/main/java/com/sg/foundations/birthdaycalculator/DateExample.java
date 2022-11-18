package com.sg.foundations.birthdaycalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateExample {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        LocalDate toLd = LocalDate.parse("1992-09-29");
        System.out.println(toLd);
        LocalDate birthDate = LocalDate.parse("09/29/2022", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        DayOfWeek day = birthDate.getDayOfWeek();
        System.out.println(day.getDisplayName(TextStyle.FULL, new Locale("en")));

        LocalDate past = toLd.minusDays(29);
        System.out.println(past);


    }
}

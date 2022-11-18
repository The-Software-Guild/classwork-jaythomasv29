package com.sg.foundations.birthdaycalculator;

import org.w3c.dom.ls.LSOutput;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class BirthdayCalculator {
  public LocalDate getUserBirthday() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter you birthdate: (MM-dd-YYYY) ");
    String birthDate = scanner.nextLine();
    return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
  }

  public String getDayOfDate(LocalDate date) {
    DayOfWeek day = date.getDayOfWeek();
    return day.getDisplayName(TextStyle.FULL, Locale.getDefault());
  }

  public String getDayOfUserBirthdayThisYear(LocalDate date) {

    System.out.println("That means you were born on a " + getDayOfDate(date).toUpperCase() + "!");
    int monthOfBirthday = date.getMonthValue();
    int dateInMonth = date.getDayOfMonth();
    int currentYear = LocalDate.now().getYear();
    String dateToString;
    if(monthOfBirthday < 10) {
      dateToString = "0" + monthOfBirthday + "-" + dateInMonth + "-" + currentYear;
    }else {
    dateToString = monthOfBirthday + "-" + dateInMonth + "-" + currentYear;

    }
    LocalDate currentBirthDate = LocalDate.parse(dateToString , DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    System.out.println("This year it falls on a " + getDayOfDate(currentBirthDate) + "...");
    return getDayOfDate(currentBirthDate);
  }

  public String getToday() {
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    return formatter.format(today);
  }

  public String daysUntilNextBirthday(LocalDate birthday) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    LocalDate today = LocalDate.now();
    LocalDate nextBday = birthday.withYear(today.getYear() + 1);

    StringBuilder remainingPeriod = new StringBuilder();
    Period diff = Period.between(today, nextBday);
    remainingPeriod.append(diff.getMonths() + " months and ");
    remainingPeriod.append(diff.getDays() + " days remaining");
    return remainingPeriod.toString();
  }






}

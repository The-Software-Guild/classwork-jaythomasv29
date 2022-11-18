package com.sg.foundations.birthdaycalculator;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        BirthdayCalculator bCalc = new BirthdayCalculator();
        LocalDate userBirthday = bCalc.getUserBirthday();
        bCalc.getDayOfUserBirthdayThisYear(userBirthday);
        System.out.println("And since today is " + bCalc.getToday() + ", there's only " + bCalc.daysUntilNextBirthday(userBirthday) + " until the next one!");
    }
}

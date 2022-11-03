package com.sg.foundations.flowcontrol.arrays;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class InterestCalculator {
  public static Scanner scanner = new Scanner(System.in);

  public static void getInvestmentDetails() {
    System.out.print("How much do you want to invest? ");
    int balance = scanner.nextInt();
    System.out.print("How many years are you investing? ");
    int years = scanner.nextInt();
    System.out.print("What is the annual interest rate % growth? ");
    double interestRate = scanner.nextDouble();
    printCalculatedInvestment(balance, years, interestRate);
  }

  public static double printCalculatedInvestment(int balance, int years, double interestRate) {
    System.out.println("Calculating");
    double startOfYrBal = balance;
    for(int i = 1; i <= years; i++) {
      double ytdTotal = calculateYearlyEarning(startOfYrBal, interestRate);
      double ytdEarnings = ytdTotal - startOfYrBal;
      System.out.println("Year" + i + ": ");
      System.out.println("Began with $" + startOfYrBal);
      System.out.println("Earned $" + round(ytdTotal - startOfYrBal));
      System.out.println("Ended with $" + ytdTotal + "\n");
      startOfYrBal+=ytdEarnings;
    }
    return startOfYrBal;
  }

  public static double calculateYearlyEarning(double balance, double interestRate) {
    for(int i = 0; i <=3; i++) {
      balance += (balance * (1 + ((interestRate / 4) / 100)) - balance);
    }
    return round(balance);
  }

  public static double round(double amount) {
    DecimalFormat formatter = new DecimalFormat("#.##");
    return Double.parseDouble(formatter.format(amount));
  }

  public static void main(String[] args) {
    getInvestmentDetails();
  }

}

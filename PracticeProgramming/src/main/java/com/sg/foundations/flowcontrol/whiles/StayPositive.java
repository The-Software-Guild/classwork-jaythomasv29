package com.sg.foundations.flowcontrol.whiles;

import java.util.Scanner;

public class StayPositive {
  Scanner scanner = new Scanner(System.in);
  public StayPositive() {
    System.out.print("Enter a number to count down ");
    int countdownNum;
    countdownNum = scanner.nextInt();
    while(countdownNum < 0) {
      System.out.println("Please try again with a positive number..!");
      countdownNum = scanner.nextInt();
    }

    while(countdownNum >= 0) {
      System.out.println(countdownNum);
      countdownNum--;
    }
    System.out.println("Blast off!");
  }

  public static void main(String[] args) {
    new StayPositive();
  }
}

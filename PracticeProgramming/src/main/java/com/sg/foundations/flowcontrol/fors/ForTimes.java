package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class ForTimes {
  Scanner scanner = new Scanner(System.in);
  public ForTimes() {
    System.out.print("Which times table shall I recite? ");
    int number = scanner.nextInt();
    for(int i = 0; i <= 15; i++) {
      System.out.println(i + " * " + number + " is: " + i * number);
    }

  }

  public static void main(String[] args) {
    new ForTimes();
  }

}

package com.sg.foundations.classesandobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LuckySevens {
  static Scanner scanner = new Scanner(System.in);
  static Random random = new Random();
  public LuckySevens() {}

  public void playGame(){
    int rolls = 0;
    int rollAtPeakWinnings = 0;
    System.out.print("How many dollars do you have? ");
    int dollars = scanner.nextInt();
    if(dollars > 0) {
      rolls = 1; rollAtPeakWinnings = 1;
    }
    int maxEarnings = dollars;
    while(dollars > 0) {
      // continue to roll the dice (digits 1 - 6) while we still have money
      int d1 = random.nextInt(6) + 1;
      int d2 = random.nextInt(6) + 1;
      System.out.println(new ArrayList<>(Arrays.asList(rolls, dollars, d1, d2, maxEarnings)));
      if((d1 + d2) == 7) {
        dollars += 4;
      } else {
          dollars -=1;
      }
//      System.out.println(dollars);
      if(maxEarnings < dollars) {
        maxEarnings = dollars;
        rollAtPeakWinnings = rolls;
      }
      rolls += 1;
    }
    System.out.println("You are broke after " + rolls + " rolls.");
    System.out.println("You should have quit after " + rollAtPeakWinnings + " when you had $" + maxEarnings + ".");

  }
  public static void main(String[] args) {
    new LuckySevens();
  }
}

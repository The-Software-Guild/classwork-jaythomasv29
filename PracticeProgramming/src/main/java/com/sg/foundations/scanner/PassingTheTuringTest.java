package com.sg.foundations.scanner;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PassingTheTuringTest {
  Scanner scanner = new Scanner(System.in);
  public PassingTheTuringTest() {
    try {
      System.out.println("Hello there!");
      System.out.print("What's your name? ");
      String name = scanner.nextLine();
      System.out.println("\n");
      System.out.printf("Hello %s! I'm Alice. \n", name);
      System.out.print("What's your favorite color? ");
      String color = scanner.nextLine();
      System.out.println("\n");
      System.out.printf("Huh, %s? Mine's Electric Lime. \n", color);
      System.out.println("I really like limes. They're my favorite fruit, too.");
      System.out.printf("What's YOUR favorite fruit, %s? ", name);
      String fruit = scanner.nextLine();
      System.out.println("\n");
      System.out.printf("Really? %s? That's wild! \n", fruit);
      System.out.printf("Speaking of favorites, what's your favorite number? ");
      int number = scanner.nextInt();
      int aliceFavoriteNumber = -7;
      System.out.println("\n");
      System.out.println(number + " is a cool number. Mine's " + aliceFavoriteNumber);
      System.out.println("Did you know " + number + " * " + aliceFavoriteNumber + " is " + number * aliceFavoriteNumber + "? That's a cool number too!");
      System.out.println("\n");
      System.out.printf("Well, thanks for talking to me %s", name);
    } catch (Exception e) {
      System.out.println("Error while inputting your answer! Please re-run the program.");
    }


  }

  public static void main(String[] args) {
    new PassingTheTuringTest();
  }
}

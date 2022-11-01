package com.sg.foundations.flowcontrol.ifs;

import java.util.Random;
import java.util.Scanner;

public class GuessMe {
  Scanner scanner = new Scanner(System.in);
  public GuessMe() {
    Random r = new Random();
    int randomNumber = r.nextInt(101); // Generates a randomNumber from 0(inclusive) - 101 (exclusive)
    System.out.println("I've chosen a number. Betcha can't guess it!");
    System.out.print("Your guess: ");
    int guessedNumber = scanner.nextInt();
    if(randomNumber == guessedNumber) {
      System.out.println("Nice job you guessed correctly!");
      return;
    }
    if(randomNumber > guessedNumber) {
      System.out.println(guessedNumber + "? Ha, nice try - too low! I chose " + randomNumber + ".");
    } else {
      System.out.println(guessedNumber + "? Ha, nice try - too high! I chose " + randomNumber + ".");
    }

  }

  public static void main(String[] args) {
    new GuessMe();
  }
}

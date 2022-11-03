package com.sg.foundations.flowcontrol.random;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
  Scanner scanner = new Scanner(System.in);
  public GuessMeMore() {
    int low = -100;
    int high = 100;
    int range = high - low + 1;
    int randomNumber = (int) (Math.random() * range) + low;
    System.out.println(randomNumber);
    int guess;
      System.out.print("I've chosen a number between -100 and 100. Bet you can't guess it! ");

      try {
        do {
            guess = scanner.nextInt();
            if(randomNumber == guess) {
              System.out.println("Wow, nice guess! That was it!");
            }
            else if(guess < randomNumber) {
              System.out.println("Ha, nice try - too low! Try again!");
            } else {
              System.out.println("Ha, nice try - too high! Try again!");
            }
        } while(randomNumber != guess);
      } catch (InputMismatchException e) {
        System.out.println("Try guessing with a number, app is closing");
      }



  }

  public static void main(String[] args) {
    Random random = new Random();
    for(int i = 0; i < 500; i++) {
    int r = random.nextInt(201) - 100;
      System.out.println(r);
    }
//    new GuessMeMore();
  }
}

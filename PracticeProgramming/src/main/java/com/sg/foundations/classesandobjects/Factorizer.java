package com.sg.foundations.classesandobjects;

import java.util.Scanner;

public class Factorizer {
  Scanner scanner = new Scanner(System.in);
  public Factorizer() {
    System.out.print("What number would you like to factor? ");
    int num = scanner.nextInt();
    System.out.println("The factors of " + num + " are:");
    getNumberOfFactors(num);
  }


  public void getNumberOfFactors(int n) {
    int numOfFactors = 0;
    int sumOfFactors = 0;
    for(int i = 1; i <= n; i++) {
      if(n % i == 0) {
        System.out.print(i + " ");
        numOfFactors++;
          sumOfFactors+=i;
      }
    }
    System.out.println("");
    System.out.println(n + " has " + numOfFactors + " factors.");
    // print if n is a perfect number
    if((sumOfFactors - n) == n) {
      System.out.println(n + " is a perfect number.");
    } else {
      System.out.println(n + " is not a perfect number.");
    }
    // print if n is prime
    if(numOfFactors == 2) {
      System.out.println(n + " is a prime number.");
    } else {
      System.out.println(n + " is not a prime number.");
    }
  }
  public static void main(String[] args) {
    new Factorizer();
  }
}

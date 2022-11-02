package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class TraditionalFizzBuzz {
  Scanner scanner = new Scanner(System.in);
    public TraditionalFizzBuzz() {
      System.out.print("How many units of fizzing and buzing do you need in your life? ");
      try {
        int times = scanner.nextInt();

        for(int i = 0; i <= times; i++) {
          if(i % 3 == 0 && i % 5 == 0) {
            System.out.println("fizz buzz");
          }
          else if (i % 3 == 0 && i % 5 != 0) {
            System.out.println("fizz");
          }
          else if(i % 3 != 0 && i % 5 == 0) {
            System.out.println("buzz");
          } else {
            System.out.println(i);
          }
        }
        System.out.println("TRADITION!!!!!!");
      } catch (Exception e) {
        System.out.println(e);
      }

    }

  public static void main(String[] args) {
    new TraditionalFizzBuzz();
  }
}

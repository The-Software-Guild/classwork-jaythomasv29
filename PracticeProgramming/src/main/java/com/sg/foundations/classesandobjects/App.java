package com.sg.foundations.classesandobjects;

import java.util.Scanner;

public class App {
  static Scanner scanner = new Scanner(System.in);
  static SimpleCalculator simpleCalculator = new SimpleCalculator();
  public static void main(String[] args) {
    HelloWorld myHelloWorld = new HelloWorld();
    myHelloWorld.sayHello();

    getUserInputs();

  }

  public static void getUserInputs() {
      System.out.println("Welcome to SimpleCalculator...");
      System.out.println("What operation would you like to perform? (select a number)" +
        "\n 1) Add" +
        "\n 2) Subtract" +
        "\n 3) Multiply" +
        "\n 4) Divide" +
        "\n 0) Quit");
    int operation = scanner.nextInt();
    while(operation != 0) {
      scanner.nextLine();
      System.out.print("Enter a number for x: ");
      int x = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Enter a number for y: ");
      int y = scanner.nextInt();
      scanner.nextLine();
      performOperation(operation, x, y);
//      operation = scanner.nextInt();
      getUserInputs();

    }

  }


  public static void performOperation(int operation, int x, int y) {
    switch(operation) {
      case 1:
        System.out.println(simpleCalculator.addition(x, y));
        break;
      case 2:
        System.out.println(simpleCalculator.subtraction(x, y));
        break;
      case 3:
        System.out.println(simpleCalculator.multiply(x, y));
        break;
      case 4:
        System.out.println(simpleCalculator.divide(x, y));
        break;
      case 0:
        System.out.println("Quitting now, Thank you");
        break;
      default:
        System.out.println("Operation does not exist in program...");
    }
  }
}

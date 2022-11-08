package com.sg.foundations.classesandobjects;

public class SimpleCalculatorApplication {
  static UserIO userIO = new UserIO();
  static SimpleCalculator simpleCalculator = new SimpleCalculator();

  public static void main(String[] args) {
    getUserInputs();
  }


  public static void getUserInputs() {
    System.out.println("Welcome to SimpleCalculator...");
    int operation = userIO.readInt("What operation would you like to perform? (select a number)" +
      "\n 1) Add" +
      "\n 2) Subtract" +
      "\n 3) Multiply" +
      "\n 4) Divide" +
      "\n 0) Quit \n Your selection: ");
    while (operation != 0) {


      int x = userIO.readInt("Enter a number for x: ");
      int y = userIO.readInt("Enter a number for y: ");

      performOperation(operation, x, y);
      getUserInputs();
    }
  }


  public static void performOperation(int operation, int x, int y) {
    switch (operation) {
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
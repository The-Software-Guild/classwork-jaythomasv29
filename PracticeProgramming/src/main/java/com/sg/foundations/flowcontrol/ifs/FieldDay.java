package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class FieldDay {
  Scanner scanner = new Scanner(System.in);
  public FieldDay() {

    System.out.print("What's your last name? ");
    String lastName = scanner.nextLine();
    if(lastName.compareTo("Baggins") <= -1 )  {
      System.out.println("Aha! You're on the team Red Dragons");
    } else if (lastName.compareTo("Baggins") >= 0 && lastName.compareTo("Dresden") <= -1) {
      System.out.println("Aha! You're on the team Dark Wizards");
    } else if (lastName.compareTo("Dresden") >= 0 && lastName.compareTo("Howl") <= -1) {
      System.out.println("Aha! You're on the team Moving Castles");
    } else if (lastName.compareTo("Howl") >= 0 && lastName.compareTo("Potter") <= -1) {
      System.out.println("Aha! You're on the team Golden Snitches");
    } else if (lastName.compareTo("Potter") >= 0 && lastName.compareTo("Vimes") <= -1) {
      System.out.println("Aha! You're on the team Night Guards");
    } else {
      System.out.println("Aha! You're on the team Black Holes");
    }
    System.out.println("Good luck in the games");
  }

  public static void main(String[] args) {
  new FieldDay();
  }
}

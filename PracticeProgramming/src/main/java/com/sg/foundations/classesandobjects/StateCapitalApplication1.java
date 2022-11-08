package com.sg.foundations.classesandobjects;

public class StateCapitalApplication1 {
  public static void main(String[] args) {
    StateCapitals1 stateCapitals = new StateCapitals1();
    System.out.println("STATES:");
    System.out.println("=======");
    stateCapitals.printStates();
    System.out.println("CAPITALS:");
    System.out.println("=======");
    System.out.println("STATE/CAPITAL PAIRS:");
    System.out.println("====================");
    stateCapitals.printStateAndCapitals();


  }
}

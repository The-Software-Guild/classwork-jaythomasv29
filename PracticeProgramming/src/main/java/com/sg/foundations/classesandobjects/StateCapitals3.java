package com.sg.foundations.classesandobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StateCapitals3 {
  static StateCapitalsReadFile s = new StateCapitalsReadFile();
  static UserIO userIO = new UserIO();

  public static void main(String[] args) {
    printStateCapitalPairs();
    int popLimit = userIO.readInt(" Please enter the lower limit for capital city population: ");
    printStateCapitalPairsAbovePopulationRange(popLimit);
    double sqMilesLimit = userIO.readDouble(" Please enter the upper limit for capital city sq mileage: ");
    printStateCapitalPairsWithinSquareMiles(sqMilesLimit);

  }
  public static void printStateCapitalPairs() {
    System.out.println(s.stateCapitals.keySet().size() + " STATE/CAPITAL PAIRS LOADED");
    System.out.println("==============================");
    Set<String> keys = s.stateCapitals.keySet();
    for(String key : keys) {
      String[] stateProperties = s.stateCapitals.get(key);
      System.out.println(key + " - " + String.join(" | ", stateProperties)); //stateProperties.
    }

  }

  public static void printStateCapitalPairsAbovePopulationRange(int popLimit) {
    System.out.println(s.stateCapitals.keySet().size() + " STATE/CAPITAL PAIRS LOADED");
    System.out.println("==============================");
    Set<String> keys = s.stateCapitals.keySet();
    System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + popLimit);
    for(String key : keys) {
      String[] stateProperties = s.stateCapitals.get(key);
      if(Integer.parseInt(stateProperties[1]) > popLimit) {
      System.out.println(key + " - " + stateProperties[0] + " | Pop: " + stateProperties[1] + " | Area: " + stateProperties[2] + " sq mi");
      }
    }

  }public static void printStateCapitalPairsWithinSquareMiles(double sqMiles) {
    System.out.println(s.stateCapitals.keySet().size() + " STATE/CAPITAL PAIRS LOADED");
    System.out.println("==============================");
    Set<String> keys = s.stateCapitals.keySet();
    System.out.println("LISTING CAPITALS WITH AREA LESS THAN " + sqMiles);
    for(String key : keys) {
      String[] stateProperties = s.stateCapitals.get(key);
      if(Double.parseDouble(stateProperties[2]) < sqMiles) {
      System.out.println(key + " - " + stateProperties[0] + " | Pop: " + stateProperties[1] + " | Area: " + stateProperties[2] + " sq mi");
      }
    }

  }

}

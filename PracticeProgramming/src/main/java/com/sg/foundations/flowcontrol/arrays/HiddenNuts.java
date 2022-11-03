package com.sg.foundations.flowcontrol.arrays;

import java.util.Random;

public class HiddenNuts {
  public static void main(String[] args) {

    String[] hidingSpots = new String[100];
    Random squirrel = new Random();
    hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
    System.out.println("The nut has been hidden ...");

    // Nut finding code should go here!
    int start = 0;
    int end = hidingSpots.length - 1;
    while(start != end) {
      if(hidingSpots[start] != null && hidingSpots[start].equals("Nut")){
        System.out.println("Found it! It's in spot# " + start);
        return;
      } else if(hidingSpots[end] != null && hidingSpots[end].equals("Nut")) {
        System.out.println("Found it! It's in spot# " + end);
        return;
      }
      start++;
      end--;
    }
  }
}

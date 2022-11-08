package com.sg.foundations.classesandobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class StateCapitals2 {
  private static Scanner scanner = new Scanner(System.in);
  private static Random random = new Random();
  private Map<String, String> map = new HashMap<>();
  private String[][] states = {
    {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
    {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
    {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
    {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
    {"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
    {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
    {"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"},
    {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"},
    {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
    {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"},
    {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
    {"Montana", "Helena"}, {"Nebraska", "Lincoln"},
    {"Nevada	", "Carson City"}, {"New Hampshire", "Concord"},
    {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"},
    {"New York", "Albany"}, {"North Carolina", "Raleigh"},
    {"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
    {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"},
    {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},
    {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"},
    {"Tennessee", "Nashville"}, {"Texas", "Austin"},
    {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
    {"Virginia", "Richmond"}, {"Washington", "Olympia"},
    {"West Virginia", "Charleston"}, {"Wisconsin", "Madison"},
    {"Wyoming", "Cheyenne"}};
  public StateCapitals2() {
    for (int i = 0; i < states.length; i++) {
      map.put(states[i][0], states[i][1]);
    }
  }
  public void printStates() {
    for(String key: map.keySet()) {
      System.out.print(key + " ");

    }
  }
  public void playGame() {
    System.out.println("HERE ARE THE STATES: ");
    printStates();
    System.out.println("-------");
    System.out.println("How many times do you want to play? ");
    int times = scanner.nextInt();
    scanner.nextLine();
    int score = 0;
    for(int i = 1; i <= times; i++) {
    int randomStateIndex = random.nextInt(50) + 1; // (1(Inclusive) - 50(Inclusive) )
    String state = states[randomStateIndex][0];
    System.out.println("READY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF '" + state + "'");
    String userGuess = scanner.nextLine();
      if (userGuess.equalsIgnoreCase(map.get(state))) {
        score++;
        System.out.println("NICE  WORK " + map.get(state) + " is CORRECT");
      } else {
        System.out.println("INCORRECT");
      }
    }
    System.out.println("Your score is: " + score + " out of " + times);

  }
}

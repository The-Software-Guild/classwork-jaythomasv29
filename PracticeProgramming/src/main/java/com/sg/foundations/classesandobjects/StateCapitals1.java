package com.sg.foundations.classesandobjects;

import java.util.HashMap;
import java.util.Map;

public class StateCapitals1 {
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
  public StateCapitals1 () {
    for (int i = 0; i < states.length; i++) {
      map.put(states[i][0], states[i][1]);
    }
  }




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
    public void printStates() {
      for(String key: map.keySet()) {
        System.out.println(key);
      }
    }

      public void printCapitals() {
        for(String value: map.values()) {
          System.out.println(value);
        }
      }

      public void printStateAndCapitals() {
    for(String key: map.keySet()) {
      System.out.println(key + " - " + map.get(key));
    }
      }


}

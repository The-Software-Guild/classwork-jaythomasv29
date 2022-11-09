package com.sg.foundations.classesandobjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class StateCapitalsReadFile {
  HashMap<String, String[]> stateCapitals = new HashMap<>();

public StateCapitalsReadFile() {
  this.stateCapitals = setStateCapitals();
}

  public void printStates() {
    for(String state : this.stateCapitals.keySet()) {
      System.out.println(state);
    }
  }

  private HashMap<String, String[]> setStateCapitals() {
//    HashMap<String, String[]> rawStateCapitals = readToHash("https://the-software-guild.s3.amazonaws.com/bootcamp-v2.6/oop-java/m2/data-files/MoreStateCapitals.txt");
    HashMap<String, String[]> stateCapitals = new HashMap<>();
    try {
      URL url = new URL("https://the-software-guild.s3.amazonaws.com/bootcamp-v2.6/oop-java/m2/data-files/MoreStateCapitals.txt");
      BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(url.openStream()));

      String inputLine;
      while ((inputLine = bufferedReader.readLine()) != null) {
        stateCapitals.put(inputLine.split("::")[1], new String[]{inputLine.split("::")[1], inputLine.split("::")[2], inputLine.split("::")[3] });
      }

      bufferedReader.close();

    } catch (IOException e) {
      System.out.println(e);
    }
//    this.stateCapitals = stateCapitals;
    return stateCapitals;
  }


}

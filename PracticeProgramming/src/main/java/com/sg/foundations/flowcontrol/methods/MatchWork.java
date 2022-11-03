package com.sg.foundations.flowcontrol.methods;

public class MatchWork {
  public static void main(String[] args) {

    System.out.println(" The word Cart should come before Horse alphabetically : " + comesBefore("Cart", "Horse"));
    System.out.println(" Half of 42 = " + halfOf(3.14));
    System.out.println(" (short) Pi = " + pi());
    System.out.println(" The first letter of the word Llama is: " + firstLetter("Llama"));
    System.out.println(" 1337 x 1337 = " + times1337(1337));

  }

  public static double pi(){
    return 3.14;
  }

  public static int times1337(int x){
    return x * 1337;
  }

  public static double halfOf(double y){
    return y / 2;
  }

  public static String firstLetter(String word){
    return word.substring(0, 1);
  }

  public static boolean comesBefore(String a, String b){
    return a.compareToIgnoreCase(b) < 0;
  }
}

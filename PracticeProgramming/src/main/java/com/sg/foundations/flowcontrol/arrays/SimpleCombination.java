package com.sg.foundations.flowcontrol.arrays;

import java.util.Arrays;

public class SimpleCombination {
  public static void main(String[] args) {
    int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 35, 45, 47, 49}; // 12 numbers
    int[] secondHalf = {51, 54, 68, 71, 75, 78, 82, 84, 85, 89, 91, 100}; // also 12!

    int[] wholeNumbers = new int[24];
    for(int i = 0; i < firstHalf.length; i++) {
      wholeNumbers[i] = firstHalf[i];
      wholeNumbers[i + 12] = secondHalf[i];
    }
    System.out.println("All together now!: ");
    for(int n : wholeNumbers) System.out.print(n + " ");
//    System.out.println(Arrays.toString(wholeNumbers));
  }
}

package com.sg.foundations.flowcontrol.arrays;

public class StillPositive {
  public static final int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};

  public static void main(String[] args) {
    System.out.println("Gotta stay positive ...!");
    printPositiveIntegers(numbers);
  }

  public static void printPositiveIntegers(int[] nums) {
    for (int n : nums) {
      if(n >= 0) {
        System.out.print(n + " ");
      }
    }
  }

}

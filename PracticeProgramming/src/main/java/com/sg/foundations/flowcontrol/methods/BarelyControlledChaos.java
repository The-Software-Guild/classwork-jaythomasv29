package com.sg.foundations.flowcontrol.methods;

import java.util.Random;

public class BarelyControlledChaos {
  public static final Random random = new Random();

  public static String getRandomColor() {
    String[] colors = {"red", "purple", "blue", "green", "yellow"};
    return colors[random.nextInt(colors.length)];
  }

  public static String getRandomAnimal() {
    String[] animals = {"llama", "penguin", "bear", "gorilla", "zebra"};
    return animals[random.nextInt(animals.length)];
  }

  public static int getRandomInteger(int low, int high) {
    return random.nextInt(high) + low;
  }

  public static void main(String[] args) {

        String color = getRandomColor(); // call color method here
        String animal = getRandomAnimal(); // call animal method again here
        String colorAgain = getRandomColor(); // call color method again here
        int weight = getRandomInteger(5, 200); // call number method,
      // with a range between 5 - 200
        int distance = getRandomInteger(10, 20); // call number method,
      // with a range between 10 - 20
        int number = getRandomInteger(10000, 20000); // call number method,
      // with a range between 10000 - 20000
        int time = getRandomInteger(2, 6); // call number method,
      // with a range between 2 - 6

      System.out.println("Once, when I was very small...");

      System.out.println("I was chased by a " + color + ", "
        + weight + "lb " + " miniature " + animal
        + " for over " + distance + " miles!!");

      System.out.println("I had to hide in a field of over "
        + number + " " + colorAgain + " poppies for nearly "
        + time + " hours until it left me alone!");

      System.out.println("\nIt was QUITE the experience, "
        + "let me tell you!");

  }
}

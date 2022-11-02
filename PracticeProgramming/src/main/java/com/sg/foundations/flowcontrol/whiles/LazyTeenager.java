package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

public class LazyTeenager {
  public LazyTeenager() {
    Random random = new Random();
    int numberOfTimes = 0;
    int percentage = 10;
    int range = random.nextInt(1, 101);
    do {
      numberOfTimes++;
      System.out.println("Clean your room!! (x" + numberOfTimes + ")");
      percentage+=10;
      if(percentage >= range) {
        System.out.println("FINE I'LL CLEAN MY ROOM.");
        break;
      }
      else if(numberOfTimes == 7) {
        System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
        break;
    }
    } while (percentage < range);

  }

  public static void main(String[] args) {
    new LazyTeenager();
  }
}

package com.sg.foundations.classesandobjects;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
  // class fields
  static Scanner scanner = new Scanner(System.in);
  static Random random = new Random();
  static int ties = 0;
//  static int rounds = getRounds();
  static int computerWins = 0;
  static int userWins = 0;

  // Main Game Logic
  public void playRounds() {
    int rounds = getRounds();
    for (int i = 1; i <= rounds; i++) {
      System.out.println("********** ROUND " + i + " **********");
      //      1 = rock, 2 = paper, 3 = scissors
      int userChoice = getUserChoice();  // run helper method to get user input
      int computerChoice = generateRandomChoice();  // run helper method to generate computer choicec

      if (userChoice == computerChoice) {
        System.out.println("Tie round!");
        ties++;
        /* case where user: rock && computer: scissors OR
          user: paper && computer : rock
          user: scissors && computer: paper
          */
      } else if ((userChoice == 1 && computerChoice == 3) || (userChoice == 2 && computerChoice == 1) || (userChoice == 3 && computerChoice == 2)) {
        System.out.println("Looks like you won!");
        userWins++;
      } else {
        System.out.println("Better luck next time...");
        computerWins++;
      }
      System.out.println("Your choice: " + convertIntChoiceToString(userChoice) + " vs. Computer Choice: " + convertIntChoiceToString(computerChoice));
    }
    System.out.println("Game stats: \n" + "Total rounds: " + rounds + " \n Your wins: " + userWins + "\n Computer wins: " + computerWins + "\n Ties: " + ties);
    if (userWins > computerWins) {
      System.out.println("You were the overall winner");
    } else if (computerWins > userWins) {
      System.out.println("Computer is the overall winner");
    } else {
      System.out.println("The overall battle was a draw");
    }
    System.out.println("Do you want to play again? (Y: yes / N: to quit)");
    String userReplayChoice = scanner.next();
    if (userReplayChoice.equalsIgnoreCase("y")) {
      ties = 0;
      computerWins = 0;
      userWins = 0;
      playRounds();
    } else {
      System.out.println("Thanks for playing!");
      scanner.close();
    }
  }

  public int getRounds() {
    System.out.print("How many rounds do you want to play? ");
    int rounds = scanner.nextInt();
    if (rounds > 10 || rounds < 1) {
      System.out.println("Error, please select a round between 1 - 10");
      return -1;
    }
    return rounds;
  }

  public int getUserChoice() {
    System.out.println("Select your choice: \n 1) Rock \n 2) Paper \n 3) Scissors");
    int choice = scanner.nextInt();
    return choice;
  }

  public String convertIntChoiceToString(int choice) {
    switch (choice) {
      case 1:
        return "Rock";
      case 2:
        return "Paper";
      case 3:
        return "Scissors";
      default:
        return "Invalid Choice";
    }
  }

  public int generateRandomChoice() {
    // generate a random number between 1 (inclusive) - 3 (exclusive)
    return random.nextInt(3) + 1;
  }

}

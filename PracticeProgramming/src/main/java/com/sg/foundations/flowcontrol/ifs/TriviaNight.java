package com.sg.foundations.flowcontrol.ifs;

import java.util.*;

public class TriviaNight {
  Scanner scanner = new Scanner(System.in);

  List<String> questionsLists = new ArrayList<>(Arrays.asList("What color is a panda bear?", "Who is the current president of the United States in 2022?", "How old do you have to be to drink in the United States?"));
  List<String> answersList = new ArrayList<>(Arrays.asList("A", "C", "D"));
  List<String> userChoices = new ArrayList<>();
  public TriviaNight() {
    System.out.println("It's TRIVIA NIGHT! Are you ready?!");
    HashMap<String, String[]> choices = new HashMap<>();
    choices.put(questionsLists.get(0), new String[]{"Black and White", "Black and Yellow", "Green and Blue", "Purple"});
    choices.put(questionsLists.get(1), new String[]{"Stephen Curry", "Joe Miden", "Joe Biden", "James Bond"});
    choices.put(questionsLists.get(2), new String[]{"15", "18", "30", "21"});

    for(int i = 0; i < questionsLists.size(); i++) {
      System.out.println(questionsLists.get(i));
      printPossibleAnswers(choices, questionsLists.get(i));
    }
    System.out.println("Nice job - you got " + calculateScore(answersList, userChoices) + " correct!");
    System.out.println("Let's review...");
    printQuestionReview();
  }

  public void printPossibleAnswers(HashMap<String, String[]> answerChoices, String question) {
    String[] letters = {"A", "B", "C", "D"};
    String[] possibleAnswers = answerChoices.get(question);
    for(int i = 0; i < possibleAnswers.length; i++) {
      System.out.println(letters[i] + ") " + possibleAnswers[i]);
    }
    getUserAnswers();
  }

  public void getUserAnswers() {
    System.out.print("YOUR ANSWER: ");
    String answer = scanner.nextLine();
    userChoices.add(answer);
  }

  public int calculateScore(List<String> answers, List<String> userAnswers) {
    int score = 0;
    for(int i = 0; i < answers.size(); i++) {
      if(answers.get(i).equalsIgnoreCase(userAnswers.get(i))) score++;
    }
    return score;
  }

  public void printQuestionReview() {
    for(int i = 0; i < questionsLists.size(); i++) {
      String isCorrect = answersList.get(i).equalsIgnoreCase(userChoices.get(i)) ? "CORRECT" : "INCORRECT";
      System.out.println(questionsLists.get(i));
      System.out.println("You guessed: " + isCorrect + " Your answer: "  + userChoices.get(i) + " Correct Answer: " + answersList.get(i));
    }

  }

  public static void main(String[] args) {
    new TriviaNight();
  }
}

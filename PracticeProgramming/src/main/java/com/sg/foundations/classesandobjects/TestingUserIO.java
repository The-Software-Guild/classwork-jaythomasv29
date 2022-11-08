package com.sg.foundations.classesandobjects;

public class TestingUserIO {
  public static void main(String[] args) {
    UserIO userIO = new UserIO();
    int smallNum = userIO.readInt("Give me a small number: ");
    int bigNum = userIO.readInt("Now give me a much bigger number! : ");
    if(bigNum < smallNum){
      userIO.print("Hey! " + smallNum +" is BIGGER than " + bigNum);
      userIO.print("I guess I can fix it.");
      int swapNum = bigNum;
      bigNum = smallNum;
      smallNum = swapNum;
    }
    int betweenNum = userIO.readInt("Now give me one in between! : ", smallNum, bigNum);
    userIO.print("I like the number "+betweenNum+"!");
  }
}

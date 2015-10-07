package HeadFirstJava.Chapter6;

import HeadFirstJava.Chapter5_ExtraStrengthMethod.SimpleDotCom;

public class GameHelperTestDrive {
  public static void main(String[] args) {
    int numberOfGuesses = 0;
    GameHelper helper = new GameHelper();
    SimpleDotCom theDotCom = new SimpleDotCom();
    int randomNum = (int) (Math.random() * 5);
    int[] location = {randomNum, randomNum+1, randomNum+2};
    theDotCom.setLocationCell(location);

    boolean isAlive = true;
    while (isAlive==true) {
      String guess = helper.getUserInput("Enter a Number");
      String result = theDotCom.checkYourSelf(guess);
      numberOfGuesses++;
      if (result.equals("kill")) {
        isAlive = false;
        System.out.println("You took " + numberOfGuesses + " guesses");
      }
    }
  }
}

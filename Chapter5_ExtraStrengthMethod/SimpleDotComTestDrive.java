package HeadFirstJava.Chapter5_ExtraStrengthMethod;

public class SimpleDotComTestDrive {
  public static void main(String[] args) {
    SimpleDotCom simpleDotCom = new SimpleDotCom();
    int[] location = {2,3,4};
    simpleDotCom.setLocationCell(location);
    String userGuess = "3";
    String result = simpleDotCom.checkYourSelf(userGuess);
  }
}

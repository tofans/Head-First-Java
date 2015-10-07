package HeadFirstJava.Chapter5_ExtraStrengthMethod;

public class SimpleDotCom {

  int [] locationCell;
  int numOfHits = 1;

  public void setLocationCell(int[] loc) {
    locationCell = loc;
  }

  public String checkYourSelf(String stringGuess) {
    int guess = Integer.parseInt(stringGuess);
    String result = "miss";
    for (int cell : locationCell) {
      System.out.println(cell);
      if (guess == cell ) {
        result = "hit";
        numOfHits++;
        System.out.println(numOfHits);
        break;
      }
    }
    if (numOfHits == locationCell.length) {
      result = "kill";
    }
    //System.out.println(locationCell.length);
    System.out.println(result);
    return result;
  }
}

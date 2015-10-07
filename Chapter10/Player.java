package HeadFirstJava.Chapter10;

class Player {
  static int playerCount = 0;
  private String name;

  public Player(String aName) {
    name = aName;
    playerCount++;
  }
}

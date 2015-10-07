package HeadFirstJava.Chapter10;

public class PlayerTestDrive {
  public static void main(String[] args) {
    System.out.println(Player.playerCount+5);
    Player one = new Player("Tiger Wodds");
    System.out.println(Player.playerCount);
  }
}

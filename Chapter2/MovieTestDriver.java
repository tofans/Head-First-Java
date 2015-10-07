package HeadFirstJava.Chapter2;

public class MovieTestDriver {
  public static void main(String[] args) {
    Movie one = new Movie();
    one.title = "AADC";
    one.genre = "Love";
    one.rating = 1;
    one.playIt();

    Movie two = new Movie();
    two.title = "The Raid";
    two.genre = "Action";
    two.rating = 2;
    two.playIt();
  }
}

package HeadFirstJava.Chapter1;

public class FirstLoop {

  public static void main(String[] args) {
    int x = 3;
    String name = "DIRK";

    x = x * 7;
    System.out.println("X is " + x);
    double z = Math.random();

    while (x > 12) {
      x = x - 1;
    }

    for (x = 0 ; x < 10 ; x++) {
      System.out.println("X is now " + x);
      final int i = x == 7 ? 7 : x == 5 ? 5 : 0;
      System.out.println("I = " + i);
    }

  }
}

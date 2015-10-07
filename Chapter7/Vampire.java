package HeadFirstJava.Chapter7;

import java.util.Objects;

class Vampire extends Monster{

  boolean frighten(int x) {
    System.out.println("a bite?");
    return false;
  }
}

package HeadFirstJava.Chapter10;

import sun.plugin2.os.windows.FLASHWINFO;

public class Duck {

  private static int size;
  // static variable = static method == GOOD
  // static variable != static method == ERROR

  public static void main(String[] args) {
    System.out.println("Size of Duck is " + size);
  }

  public int getSize() {
    return size;
  }

  public void setSize(int aSize) {
    aSize = 10;
    size = aSize;
  }
}

package HeadFirstJava.Chapter7;

public class C extends B {

  @Override
  void m3() {
    super.m3();
    System.out.print("C's m3, " + (ivar + 6));
  }
}

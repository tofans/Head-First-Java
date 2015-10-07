package HeadFirstJava.Chapter12_GUI;

class MyOuter {

  private int x;

  MyInner inner = new MyInner();
  public void doStuff() {
    inner.go();
  }

  class MyInner {
    void go() {
      x = 42;
    }
  }
}

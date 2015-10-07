package HeadFirstJava.Chapter12_GUI;

class Foo {
  public static void main(String[] args) {
    MyOuter outer = new MyOuter();
    MyOuter.MyInner inner = outer.new MyInner();
  }
}

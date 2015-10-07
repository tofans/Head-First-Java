package HeadFirstJava.Chapter3_PrimitiveReference;

class Triangle {
  double area;
  int height;
  int length;

  public static void main(String[] args) {
    int x = 0;
    Triangle[] ta = new Triangle[4];
    while (x < 4) {
      x = x + 1;
      ta[x].height = (x+1) + 2;
      ta[x].length = x + 4;

      System.out.println("triangle " + x + ", area");
      System.out.println(" = " + ta[x].area);

    }
  }
}

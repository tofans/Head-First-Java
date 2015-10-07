package HeadFirstJava.Chapter11_ExceptionHandling;

public class ExTestDrive {
  public static void main(String[] args) {
    String test = args[0];
    try {
      System.out.println("t");
      doRiskyTest(test);
      System.out.println("o");
    }catch (MyEx aEx) {
      System.out.println("a");
    }finally {
      System.out.println("w");
    }
    System.out.println("s");
  }

  static void doRiskyTest(String aTest) throws MyEx{
    System.out.println("h");
    if ("yes".equals(aTest)){
      throw new MyEx();
    }
    System.out.println("r");
  }
}

package HeadFirstJava.Chapter11_ExceptionHandling;

public class TestExceptions {

  public static void main(String[] args) {
    String test = "yes";
    try {
      System.out.println("Start try");
      doRisky(test);
      System.out.println("end try");
    } catch (Exception e) {
      System.out.println("exception");
    } finally {
      System.out.println("finally");
    }
  }

  static void doRisky(String aTest) throws Exception{
    System.out.println("start risky");
    if ("yes".equals(aTest)) {
      throw new Exception();
    }
    System.out.println("end risky");
    return;
  }
}

package HeadFirstJava.Chapter9Constructor;

public class SimUnit {

  String botType;

  public SimUnit(String type) {
    botType = type;
  }

  int powerUse() {
    //if ("Retention".equals(botType)) {
    //  return 2;
    //} else {
    //  return 4;
    //}
    return "Retention".equals(botType) ? 2 : 4;
  }
}

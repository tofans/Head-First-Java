package HeadFirstJava.Chapter9Constructor;

import java.util.ArrayList;

class RetentionBot {
  public RetentionBot(ArrayList aList) {
    aList.add(new SimUnit("Retention"));
  }
}

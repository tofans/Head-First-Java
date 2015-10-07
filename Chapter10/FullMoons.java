package HeadFirstJava.Chapter10;

import java.util.Calendar;

public class FullMoons {

  static int DAY_IM = 1000 * 60 * 60 * 24;

  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    cal.set(2004,0,7,15,40);
    long day = cal.getTimeInMillis();
    for (int i = 0; i < 60; i++) {
      day += (DAY_IM * 29.52);
      cal.setTimeInMillis(day);
      System.out.println(String.format("Full moon on %tc ", cal));
    }
  }
}

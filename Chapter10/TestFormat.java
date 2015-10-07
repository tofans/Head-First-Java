package HeadFirstJava.Chapter10;

import java.util.Calendar;
import java.util.Date;

public class TestFormat {
  public static void main(String[] args) {
    String s = String.format("%,d", 1000000000);
    System.out.println(s);
    String a = String.format("I have $%,.2f bugs to fix", 476588.02365);
    System.out.println(a);
    String d = String.format("%d", 42);
    String f = String.format("%.3f", 42.000000);
    String h = String.format("%x", 42);
    String c = String.format("%c", 42);
    System.out.println("D : " + d + "\nF : " + f + "\nH : " + h + "\nC : " + c);

    Date dates = new Date();
    String dateTime = String.format("%tc", new Date());
    String date = String.format("%tr", new Date());
    String day = String.format("%tA, %tB %td", dates, dates, dates);
    String dayCopy = String.format("%tA, %<tB %<td", dates);
    System.out.println("Date Time : " + dateTime +
                       "\nDate : " + date +
                       "\nDay of : " + day +
                       "\nDay Copy : " + dayCopy);

    Calendar cal = Calendar.getInstance();
    cal.set(2004, 0, 7, 15, 40); //TODO set time to Jan 7, 2014 at 15:40
    long day1 = cal.getTimeInMillis(); //TODO convert to big ol amount of millisecond
    day1 += 1000 * 60 * 60; //TODO day1 = day1 + .....
    cal.setTimeInMillis(day1);
    System.out.println("New hour : " + cal.get(cal.HOUR_OF_DAY));
    cal.add(cal.DATE, 35);
    System.out.println("Add 35 days " + cal.getTime());
    cal.roll(cal.DATE, 35);
    System.out.println("Roll 35 days " + cal.getTime());
    cal.set(cal.DATE, 1);
    System.out.println("Set to 1 " + cal.getTime());
  }
}

package HeadFirstJava.Chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelpers {

  public static final String alphabet = "abcdefg";
  private int gridlength = 7;
  private int gridsize = 3;
  private int[] grid = new int[gridsize];
  private int comCount = 0;

  public String getUserInput(String prompt) {
    String inputLine = null;
    System.out.println(prompt + " ");
    try {
      BufferedReader is = new BufferedReader( new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0) return null;
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("IOException : " + e);
    }
    return inputLine.toLowerCase();
  }

  public ArrayList<String> placeDotCom(int comSize) {
    ArrayList<String> alphaCells = new ArrayList<String>();
    String [] alphaRecord = new String[comSize];
    String temp = null;
    int[] coords = new int[comSize];
    int attemps = 0;
    boolean success = false;
    int location = 0;

    comCount++;
    int incr = 1;
    if ((comCount%2) == 1) {
      incr = gridlength;
    }

    while ((!success & attemps++ < 200)) {
      location = (int) (Math.random() * gridsize);
      int x = 0;
      success = true;
      while (success && x < comSize) {
        if (grid[location] == 0) {
          coords[x++] = location;
          location += incr;
          if (location >= gridsize) {
            success=false;
          }
          if (x>0 && (location %gridlength == 0)) {
            success = false;
          }
        } else {
          success = false;
        }
      }
    }

    int x = 0;
    int row = 0;
    int column = 0;
    while (x < comSize) {
      grid[coords[x]] = 1;
      row = (int) (coords[x] / gridlength);
      column = coords[x] % gridlength;
      temp = String.valueOf(alphabet.charAt(column));

      alphaCells.add(temp.concat(Integer.toString(row)));
    }
    return alphaCells;
  }
}

package HeadFirstJava.Chapter14_Serialize;

import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {

  public static void main(String[] args) {
    try {
      FileWriter fw = new FileWriter("Foos.txt");
      fw.write("Hello File!!!");
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

package HeadFirstJava.Chapter14_Serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Box implements Serializable{

  private int width;
  private int height;

  public int getWidth() {
    return width;
  }

  public void setWidth(int aWidth) {
    width = aWidth;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int aHeight) {
    height = aHeight;
  }

  public static void main(String[] args) {
    Box myBox = new Box();
    myBox.setWidth(100);
    myBox.setHeight(200);

    //Duck duck = new Duck();

    try {
      Box box = new Box();
      FileOutputStream outputStream = new FileOutputStream("foo.ser");
      ObjectOutputStream stream = new ObjectOutputStream(outputStream);
      stream.writeObject(myBox); //Good
      //stream.writeObject(duck); //Error
      stream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

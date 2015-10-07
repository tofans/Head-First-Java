package HeadFirstJava.Chapter12_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel implements ControllerEventListener {

  boolean msg = false;

  @Override
  public void controlChange(ShortMessage event) {
    msg = true;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (msg) {
      Graphics2D graphics = (Graphics2D) g;
      int r = (int) (Math.random() * 250);
      int grt = (int) (Math.random() * 250);
      int b = (int) (Math.random() * 250);

      graphics.setColor(new Color(r, grt, b));
      int ht = (int) ((Math.random() * 120)+10);
      int width = (int) ((Math.random() * 120)+10);
      int x = (int) ((Math.random()*40) + 10);
      int y = (int) ((Math.random()*40) + 10);

      graphics.fillRect(x,y,ht,width);
      msg = false;
    }
  }
}

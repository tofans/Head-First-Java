package HeadFirstJava.Chapter12_GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Animate {
  int x=1;
  int y=1;

  public static void main(String[] args) {
    Animate gui = new Animate();
    gui.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    MyDrawP panel = new MyDrawP();
    frame.getContentPane().add(panel);
    frame.setSize(500,270);
    frame.setVisible(true);
    for (int i = 0; i < 124; i++,x++,y++) {
      x++;
      panel.repaint();
      try {
        Thread.sleep(50);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  class MyDrawP extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.WHITE);
      g.fillRect(0,0,500,250);
      g.setColor(Color.BLUE);
      g.fillRect(x,y,500-x*2,250-x*2);
    }
  }
}

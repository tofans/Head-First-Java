package HeadFirstJava.Chapter12_GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class SimpleAnimation {

  int x = 0;
  int y = 0;

  public static void main(String[] args) {
    SimpleAnimation animation = new SimpleAnimation();
    animation.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    MyDrawPanels drawPanel = new MyDrawPanels();
    frame.getContentPane().add(drawPanel);
    frame.setSize(300,300);
    frame.setVisible(true);

    for (int i = 0; i < 200; i++) {
      x++;
      y++;

      drawPanel.repaint();
      try {
        Thread.sleep(10);
      } catch (Exception e) {

      }
    }
  }

  private class MyDrawPanels extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
      g.setColor(Color.WHITE);
      g.fillRect(0,0,this.getWidth(), this.getHeight());
      g.setColor(Color.green);
      g.fillOval(x,y,40,40);
    }
  }
}

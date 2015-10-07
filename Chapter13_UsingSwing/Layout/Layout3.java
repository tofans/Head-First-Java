package HeadFirstJava.Chapter13_UsingSwing.Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout3 {
  public static void main(String[] args) {
    Layout3 gui = new Layout3();
    gui.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);

    JButton button = new JButton("tes Uji");
    JButton buttonTwo = new JButton("watari");
    panel.add(buttonTwo);

    frame.getContentPane().add(BorderLayout.SOUTH, panel);
    panel.add(buttonTwo);
    frame.getContentPane().add(BorderLayout.NORTH, button);

    frame.setSize(250,200);
    frame.setVisible(true);
  }
}

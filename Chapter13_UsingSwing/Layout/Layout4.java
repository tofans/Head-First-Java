package HeadFirstJava.Chapter13_UsingSwing.Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout4 {
  public static void main(String[] args) {
    Layout4 gui = new Layout4();
    gui.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);

    JButton button = new JButton("tes Uji");
    JButton buttonTwo = new JButton("watari");
    panel.add(button);

    frame.getContentPane().add(BorderLayout.NORTH, buttonTwo);
    frame.getContentPane().add(BorderLayout.EAST, panel);

    frame.setSize(250,200);
    frame.setVisible(true);
  }
}

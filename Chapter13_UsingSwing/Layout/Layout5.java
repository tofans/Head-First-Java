package HeadFirstJava.Chapter13_UsingSwing.Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout5 {
  public static void main(String[] args) {
    Layout5 gui = new Layout5();
    gui.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);

    JButton button = new JButton("tes Uji");
    JButton buttonTwo = new JButton("watari");
    panel.add(buttonTwo);

    frame.getContentPane().add(BorderLayout.EAST, panel);
    frame.getContentPane().add(BorderLayout.CENTER, button);

    frame.setSize(250,200);
    frame.setVisible(true);
  }
}

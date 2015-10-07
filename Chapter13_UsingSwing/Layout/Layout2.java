package HeadFirstJava.Chapter13_UsingSwing.Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout2 {
  public static void main(String[] args) {
    Layout2 gui = new Layout2();
    gui.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);

    JButton button = new JButton("tes Uji");
    JButton buttonTwo = new JButton("watari");
    panel.add(buttonTwo);

    frame.getContentPane().add(BorderLayout.NORTH, panel);
    panel.add(buttonTwo);
    frame.getContentPane().add(BorderLayout.CENTER, button);

    frame.setSize(250,200);
    frame.setVisible(true);
  }
}

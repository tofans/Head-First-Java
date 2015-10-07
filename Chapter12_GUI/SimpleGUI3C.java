package HeadFirstJava.Chapter12_GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SimpleGUI3C implements ActionListener {

  JFrame fFrame;
  public static void main(String[] args) {
    SimpleGUI3C gui = new SimpleGUI3C();
    gui.go();
  }

  private void go() {
    fFrame = new JFrame();
    fFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JButton button = new JButton("Change Color");
    button.addActionListener(this);

    MyDrawPanel drawPanel = new MyDrawPanel();
    fFrame.getContentPane().add(BorderLayout.SOUTH, button);
    fFrame.getContentPane().add(BorderLayout.CENTER, drawPanel);
    fFrame.setSize(300,300);
    fFrame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    fFrame.repaint();
  }
}

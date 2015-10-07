package HeadFirstJava.Chapter12_GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class TwoButton {
  JFrame fFrame;
  JLabel fLabel;

  public static void main(String[] args) {
    TwoButton gui = new TwoButton();
    gui.go();
  }

  private void go() {
    fFrame = new JFrame();
    fFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JButton labelButton = new JButton("Change Label");
    labelButton.addActionListener(new LabelListener());

    JButton colorButton = new JButton("Change Circle");
    colorButton.addActionListener(new ColorListener());

    fLabel = new JLabel("I'm a label");
    MyDrawPanel panel = new MyDrawPanel();

    fFrame.getContentPane().add(BorderLayout.SOUTH, colorButton);
    fFrame.getContentPane().add(BorderLayout.CENTER, panel);
    fFrame.getContentPane().add(BorderLayout.EAST, labelButton);
    fFrame.getContentPane().add(BorderLayout.WEST, fLabel);

    fFrame.setSize(300,300);
    fFrame.setVisible(true);
  }

  class LabelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      fLabel.setText("Ouchhh!!!!");
    }
  }

  class ColorListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      fFrame.repaint();
    }
  }
}

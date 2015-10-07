package HeadFirstJava.Chapter12_GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

class InnerButton {
  JFrame fFrame;
  JButton fButton;

  public static void main(String[] args) {
    InnerButton gui1 = new InnerButton();
    gui1.go();
  }

  private void go() {
    fFrame = new JFrame();
    fFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    fButton = new JButton("A");
    fButton.addActionListener(new BListener());

    fFrame.getContentPane().add(BorderLayout.SOUTH, fButton);
    fFrame.setSize(200,100);
    fFrame.setVisible(true);
  }

  class BListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (fButton.getText().equals("A")) {
        fButton.setText("B");
      } else {
        fButton.setText("A");
      }
    }
  }
}

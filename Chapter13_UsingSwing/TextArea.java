package HeadFirstJava.Chapter13_UsingSwing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea implements ActionListener{

  JTextArea fArea;

  public static void main(String[] args) {
    TextArea gui = new TextArea();
    gui.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton("Just Click It");
    button.addActionListener(this);
    fArea = new JTextArea(10,20);
    //fArea.setLineWrap(true);

    JScrollPane scroller = new JScrollPane(fArea);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    panel.add(scroller);

    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.getContentPane().add(BorderLayout.SOUTH, button);

    frame.setSize(350,300);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    fArea.append("button click \n");
  }
}

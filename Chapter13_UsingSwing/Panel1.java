package HeadFirstJava.Chapter13_UsingSwing;

import com.jgoodies.forms.builder.PanelBuilder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Panel1 {

  public static void main(String[] args) {
    Panel1 gui = new Panel1();
    gui.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.GRAY);

    //Vertical stack agar susunan button baris ke bawah
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JButton button = new JButton("Click Me !!!!");
    JButton buttonTwo = new JButton("Button Two !!!!");
    panel.add(button);
    panel.add(buttonTwo);

    frame.getContentPane().add(BorderLayout.EAST, panel);
    frame.setSize(250,200);
    frame.setVisible(true);
  }
}

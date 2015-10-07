package HeadFirstJava.Chapter13_UsingSwing;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class CheckBox implements ItemListener {

  JCheckBox check;

  public static void main(String[] args) {
    CheckBox checkBox = new CheckBox();
    checkBox.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    frame.setSize(350,300);
    frame.setVisible(true);

    check = new JCheckBox("Goes to 11");
    check.addItemListener(this);

    panel.add(check);
    frame.getContentPane().add(BorderLayout.CENTER, panel);

    check.setSelected(true);
    check.setSelected(false);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    String onOrOff = "Off";
    if (check.isSelected()) onOrOff = "On";
    System.out.println("Check box is " + onOrOff);
  }
}

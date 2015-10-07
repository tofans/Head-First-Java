package HeadFirstJava.Chapter13_UsingSwing;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest implements ListSelectionListener{

  JList fList;

  public static void main(String[] args) {
    JListTest listTest = new JListTest();
    listTest.go();
  }

  private void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    String [] listEntries = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "etha", "theta"};
    fList = new JList(listEntries);
    JScrollPane scroller = new JScrollPane(fList);

    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    fList.setVisibleRowCount(4);
    fList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    fList.addListSelectionListener(this);

    panel.add(scroller);

    frame.getContentPane().add(BorderLayout.CENTER, panel);

    frame.setSize(350, 300);
    frame.setVisible(true);

  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting()) {
      String selection = (String) fList.getSelectedValue();
      System.out.println("selection = " + selection);
    }
  }
}

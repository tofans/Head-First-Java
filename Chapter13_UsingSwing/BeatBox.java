package HeadFirstJava.Chapter13_UsingSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorListener;

public class BeatBox {

  JPanel mainPanel;
  ArrayList<JCheckBox> fCheckBoxesList;
  Sequencer fSequencer;
  Sequence fSequence;
  Track fTrack;
  JFrame theFrame;

  String[] instrumenName = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat",
                            "Accoustic Snare", "Crash Cymbal", "Hand Clap",
                            "High Tom", "Hi Bongo", "Maracas",
                            "Whistle", "Low Conga", "Cowbell",
                            "Vibraslap", "Low Mid-Tom", "High Angogo",
                            "Open Hi Conga"};
  int[] instrument = {35,32,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

  public static void main(String[] args) {
    new BeatBox().buildGUI();
  }

  private void buildGUI() {
    theFrame = new JFrame("Cyber BeatBox");
    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    BorderLayout layout = new BorderLayout();
    JPanel background = new JPanel(layout);
    background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    fCheckBoxesList = new ArrayList<JCheckBox>();
    Box buttonBox = new Box(BoxLayout.Y_AXIS);

    JButton buttonStart = new JButton("Start");
    buttonStart.addActionListener(new MyStartListener());
    buttonBox.add(buttonStart);

    JButton buttonStop = new JButton("Stop");
    buttonStop.addActionListener(new MyStopListener());
    buttonBox.add(buttonStop);

    JButton upTempo = new JButton("Up Tempo");
    upTempo.addActionListener(new MyUpTempoListener());
    buttonBox.add(upTempo);

    JButton downTempo = new JButton("Down Tempo");
    downTempo.addActionListener(new MyDownTempoListener());
    buttonBox.add(downTempo);

    Box nameBox = new Box(BoxLayout.Y_AXIS);
    for (int i = 0; i < 16; i++) {
      nameBox.add(new Label(instrumenName[i]));
    }

    background.add(BorderLayout.EAST, buttonBox);
    background.add(BorderLayout.WEST, nameBox);

    theFrame.getContentPane().add(background);

    GridLayout gridLayout = new GridLayout(16,16);
    gridLayout.setVgap(1);
    gridLayout.setHgap(2);
    mainPanel = new JPanel(gridLayout);
    background.add(BorderLayout.CENTER, mainPanel);

    for (int i = 0; i < 265; i++) {
      JCheckBox checkBox = new JCheckBox();
      checkBox.setSelected(false);
      fCheckBoxesList.add(checkBox);
      mainPanel.add(checkBox);
    }

    setUpMidi();

    theFrame.setBounds(50,50,300,300);
    theFrame.pack();
    theFrame.setVisible(true);

  }

  private void setUpMidi() {
    try {
      fSequencer = MidiSystem.getSequencer();
      fSequencer.open();
      fSequence = new Sequence(Sequence.PPQ, 4);
      fTrack = fSequence.createTrack();
      fSequencer.setTempoInBPM(120);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void buildTrackAndStart() {
    int[] trackList = null;
    fSequence.deleteTrack(fTrack);
    fTrack = fSequence.createTrack();

    for (int i = 0; i < 16; i++) {
      trackList = new int[16];

      int key = instrument[i];

      for (int j = 0; j < 16; j++) {
        JCheckBox jc = (JCheckBox) fCheckBoxesList.get(j + (16*i));
        if (jc.isSelected()) {
          trackList[j] = key;
        } else {
          trackList[j] = 0;
        }
      }
      makeTrack(trackList);
      fTrack.add(makeEvent(176,1,127,0,16));
    }

    fTrack.add(makeEvent(192,1,9,0,15));
    try {
      fSequencer.setSequence(fSequence);
      fSequencer.setLoopCount(fSequencer.LOOP_CONTINUOUSLY);
      fSequencer.start();
      fSequencer.setTempoInBPM(120);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void makeTrack(int[] list) {
    for (int i = 0; i < 16; i++) {
      int key = list[i];
      if (key!=0) {
        fTrack.add(makeEvent(144, 9, key, 100, i));
        fTrack.add(makeEvent(128, 9, key, 100, i+1));
      }
    }
  }

  private MidiEvent makeEvent(int com, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage a = new ShortMessage();
      a.setMessage(com, chan, one, two);
      event = new MidiEvent(a, tick);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return event;
  }

  private class MyStartListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      buildTrackAndStart();
    }
  }

  private class MyStopListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      fSequencer.stop();
    }
  }

  private class MyUpTempoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      float tempoFactor = fSequencer.getTempoFactor();
      fSequencer.setTempoFactor((float)(tempoFactor * 1.03));
    }
  }

  private class MyDownTempoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      float tempoFactor = fSequencer.getTempoFactor();
      fSequencer.setTempoFactor((float) (tempoFactor * .97));
    }
  }
}

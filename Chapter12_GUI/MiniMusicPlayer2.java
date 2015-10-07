package HeadFirstJava.Chapter12_GUI;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicPlayer2 implements ControllerEventListener {

  public static void main(String[] args) {
    MiniMusicPlayer2 mini = new MiniMusicPlayer2();
    mini.go();
  }

  public void go() {
    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();

      int[] eventIWant = {127};
      sequencer.addControllerEventListener(this, eventIWant);

      Sequence sequence = new Sequence(Sequence.PPQ, 4);
      Track track = sequence.createTrack();

      for (int i = 0; i < 61; i+=4) {
        track.add(makeEvent(144,1,i,100,i));
        track.add(makeEvent(176,1,127,0,i));
        track.add(makeEvent(144,1,i,100,i+2));
      }

      sequencer.setSequence(sequence);
      sequencer.setTempoInBPM(220);
      sequencer.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void controlChange(ShortMessage event) {
    System.out.println("la");
  }

  private static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage message = new ShortMessage();
      message.setMessage(comd, chan, one, two);
      event = new MidiEvent(message, tick);

    }catch (Exception ex) {
      ex.printStackTrace();
    }
    return event;
  }
}

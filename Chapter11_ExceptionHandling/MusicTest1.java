package HeadFirstJava.Chapter11_ExceptionHandling;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {
  public void play() {
    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      System.out.println("We got a sequencer");
    } catch (MidiUnavailableException e) {
      System.out.println("Summer");
    }
  }

  public static void main(String[] args) {
    MusicTest1 test1 = new MusicTest1();
    test1.play();
  }
}

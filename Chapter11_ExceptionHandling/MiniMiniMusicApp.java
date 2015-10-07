package HeadFirstJava.Chapter11_ExceptionHandling;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMiniMusicApp {
  public static void main(String[] args) {
    MiniMiniMusicApp musicApp = new MiniMiniMusicApp();
    musicApp.play();
  }

  private void play() {
    try {
      Sequencer player = MidiSystem.getSequencer();
      player.open();

      Sequence s = new Sequence(Sequence.PPQ, 4);

      Track track = s.createTrack();

      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, 44, 100);
      MidiEvent eventOn = new MidiEvent(a, 8);
      track.add(eventOn);

      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, 44, 100);
      MidiEvent eventOff = new MidiEvent(b, 16);
      track.add(eventOff);

      player.setSequence(s);
      player.start();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

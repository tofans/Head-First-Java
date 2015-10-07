package HeadFirstJava.Chapter11_ExceptionHandling;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicCMDLine {

  public static void main(String[] args) {
    MiniMusicCMDLine line = new MiniMusicCMDLine();
    System.out.println("args = " + args.length);
    if (args.length < 2) {
      System.out.println("Don't forget the instrument and not args");
    } else {
      int instrument = Integer.parseInt(args[0]);
      int note = Integer.parseInt(args[1]);
      line.play(instrument, note);
    }
  }

  private void play(int aInstrument, int aNote) {
    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      MidiEvent event = null;
      ShortMessage first = new ShortMessage();
      first.setMessage(192, 1, aInstrument, 0);
      MidiEvent midiEvent = new MidiEvent(first, 1);
      track.add(midiEvent);

      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, aNote, 100);
      MidiEvent noteOn = new MidiEvent(a, 1);
      track.add(noteOn);

      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, aNote, 100);
      MidiEvent noteOff = new MidiEvent(b, 16);
      track.add(noteOff);

      sequencer.setSequence(seq);
      sequencer.start();
    }catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

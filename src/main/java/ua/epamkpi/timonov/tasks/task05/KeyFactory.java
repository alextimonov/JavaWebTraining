package ua.epamkpi.timonov.tasks.task05;

public class KeyFactory {
    public static Key create(Octave octave, Note note) {
        Key key = new Key();
        key.setOctave(octave);
        key.setNote(note);
        return key;
    }
}

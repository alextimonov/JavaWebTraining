package ua.javaweb.timonov.tasks.task05_inheritance;

public class KeyFactory {
    public static Key create(Octave octave, Note note) {
        Key key = new Key();
        key.setOctave(octave);
        key.setNote(note);
        key.setAdjusted(true);
        return key;
    }

    public static Key create(Octave octave, Note note, boolean adjusted) {
        Key key = new Key();
        key.setOctave(octave);
        key.setNote(note);
        key.setAdjusted(adjusted);
        return key;
    }
}

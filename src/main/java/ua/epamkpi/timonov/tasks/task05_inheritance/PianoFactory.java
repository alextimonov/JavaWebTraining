package ua.epamkpi.timonov.tasks.task05_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PianoFactory {
    public static Piano create(String model, int year) {
        Piano piano = new Piano();
        List<Key> keys = new ArrayList<>();
        for (Octave octave : Octave.values()) {
            for (Note note : Note.values()) {
                keys.add(KeyFactory.create(octave, note));
            }
        }
        piano.setKeys(keys);
        piano.setModel(model);
        piano.setIssueYear(year);
        return piano;
    }

    public static Piano create(String model, int year, Key startKey, Key endKey) {
        Piano piano = new Piano();
        List<Key> keys = getKeysFromStartToEndKey(startKey, endKey);
        piano.setKeys(keys);
        piano.setModel(model);
        piano.setIssueYear(year);
        return piano;
    }

    private static List<Key> getKeysFromStartToEndKey(Key startKey, Key endKey) {
        int nStartOctave = startKey.getOctave().ordinal();
        int nEndOctave = endKey.getOctave().ordinal();
        int nStartNote = startKey.getNote().ordinal();
        int nEndNote = endKey.getNote().ordinal();
        List<Octave> octaves = Arrays.asList(Octave.values());
        List<Note> notes = Arrays.asList(Note.values());

        int firstIndexValue;
        int lastIndexValue;
        List<Key> keys = new ArrayList<>();
        for (int i = nStartOctave; i <= nEndOctave; i++) {
            firstIndexValue = i > nStartOctave ? 0 : nStartNote;
            lastIndexValue = i < nEndOctave ? notes.size() - 1 : nEndNote;;
            for (int j = firstIndexValue; j <= lastIndexValue; j++) {
                keys.add(KeyFactory.create(octaves.get(i), notes.get(j)));
            }
        }
        return keys;
    }
}

package ua.epamkpi.timonov.tasks.task05;

import java.util.ArrayList;
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
}

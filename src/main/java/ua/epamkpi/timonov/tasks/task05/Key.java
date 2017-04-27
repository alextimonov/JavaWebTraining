package ua.epamkpi.timonov.tasks.task05;

/**
 * Represents a piano key
 */
public class Key {

    /* musical octave */
    private Octave octave;

    /* musical note */
    private Note note;

    public Key() {
    }

    /**
     * adjusts the key and prints message
     */
    public void adjust() {
        // some code to adjust the key
        String message = toString() + " is adjusted";
        System.out.println(message);
    }

    /**
     * makes the pressed and
     */
    public void press() {
        // some code to press the key
        String message = toString() + " is pressed";
        System.out.println(message);
    }

    @Override
    public String toString() {
        return String.format("Key {octave=%-14s, note=%-9s (%2s%-2d)}", octave, note, note.getSign(), octave.getValue());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Key thatKey = (Key) object;
        if (octave.ordinal() != thatKey.octave.ordinal()) {
            return false;
        }
        return note.ordinal() == thatKey.note.ordinal();
    }

    @Override
    public int hashCode() {
        int multiplier = Note.values().length + 1;           // there are 12 regular notes, multiplier should be 13
        int result = (octave != null ? octave.ordinal() : -1);
        result = multiplier * result + (note != null ? note.ordinal() : -1);
        return result;
    }

    /* =========== Getters & setters =========== */

    public Octave getOctave() {
        return octave;
    }

    public void setOctave(Octave octave) {
        this.octave = octave;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}

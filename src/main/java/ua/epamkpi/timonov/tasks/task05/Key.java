package ua.epamkpi.timonov.tasks.task05;

/**
 * Represents a piano key
 */
public class Key {

    /* musical octave */
    private Octave octave;

    /* musical note */
    private Note note;

    /* true if key is adjusted */
    private boolean isAdjusted;

    /* true if key is pressed */
    private boolean isPressed;

    public Key() {
    }

    public Key(Octave octave, Note note, boolean isAdjusted) {
        this.octave = octave;
        this.note = note;
        this.isAdjusted = isAdjusted;
    }

    /**
     * makes the key pressed
     */
    public void press() {
        isPressed = true;
        // delay if necessary
    }

    /**
     * releases the key
     */
    public void release() {
        isPressed = false;
    }

    /**
     * adjusts the key and prints message
     */
    public void adjust() {
        press();
        release();
        if (!isAdjusted) {
            setAdjusted(true);
        }
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
        if (octave != thatKey.octave) {
            return false;
        }
        return note == thatKey.note;
    }

    @Override
    public int hashCode() {
        int multiplier = Note.values().length + 1;     // there are 12 regular notes, multiplier should be 13
        int result = (octave != null ? octave.ordinal() : -1);
        result = multiplier * result + (note != null ? note.ordinal() : -1);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Key {%-14s %-9s (%2s%-2d), is pressed=%-5b, is adjusted=%-5b}",
                octave, note, note.getSign(), octave.getValue(), isPressed, isAdjusted);
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

    public boolean isAdjusted() {
        return isAdjusted;
    }

    public void setAdjusted(boolean adjusted) {
        isAdjusted = adjusted;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}

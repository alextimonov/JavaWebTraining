package ua.epamkpi.timonov.tasks.task05;

import java.util.ArrayList;
import java.util.List;

public class Melody {
    private List<Key> keySequence = new ArrayList<>();

    public Melody() {
    }

    public Melody(List<Key> keySequence) {
        this.keySequence = keySequence;
    }

    public List<Key> getKeySequence() {
        return keySequence;
    }

    public void setKeySequence(List<Key> keySequence) {
        this.keySequence = keySequence;
    }

    @Override
    public String toString() {
        return "Melody{" +
                "keySequence=" + keySequence +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Melody)) return false;

        Melody melody = (Melody) o;

        return keySequence != null ? keySequence.equals(melody.keySequence) : melody.keySequence == null;

    }

    @Override
    public int hashCode() {
        return keySequence != null ? keySequence.hashCode() : 0;
    }
}

package ua.epamkpi.timonov.tasks.task05;

import java.util.*;

/**
 * Represents piano with seed of piano keys
 */
public class Piano {

    /* model's name */
    private String model;

    /* year of piano's issue */
    private int issueYear;

    /* piano keys */
    private List<Key> keys = new ArrayList<>();

    public Piano() {
    }

    /**
     * adjusts each piano's key
     */
    public void adjust() {
        for (Key key : keys) {
            key.adjust();
        }
    }

    /**
     * plays random piano keys
     * @param keysNumber    number of keys to be played
     */
    public void playRandomKeys(int keysNumber) {
        Random random = new Random();
        for (int i = 0; i < keysNumber; i++) {
            int index = (int) (random.nextDouble() * keys.size());
            keys.get(index).press();
        }
    }

    @Override
    public String toString() {
        return "Piano {" + "model=" + model + ", year=" + issueYear + ", \n" +
                "keys from " + keys.get(0) + " to " + keys.get(keys.size() - 1) + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Piano)) {
            return false;
        }
        Piano thatPiano = (Piano) object;
        if (issueYear != thatPiano.issueYear) {
            return false;
        }
        if (model != null ? !model.equals(thatPiano.model) : thatPiano.model != null) return false;
        return keys != null ? keys.equals(thatPiano.keys) : thatPiano.keys == null;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + issueYear;
        result = 31 * result + (keys != null ? keys.hashCode() : 0);
        return result;
    }

    /* ========== Getters & setters =========== */

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }
}

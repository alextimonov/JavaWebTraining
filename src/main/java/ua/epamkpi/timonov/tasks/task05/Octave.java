package ua.epamkpi.timonov.tasks.task05;

/**
 * Represents musical octave with its english values
 */
public enum Octave {
    SUB_SUB_CONTRA(-1), SUB_CONTRA(0), CONTRA(1), GREAT(2), SMALL(3), ONE_LINED(4), TWO_LINED(5), THREE_LINED(6),
    FOUR_LINED(7), FIVE_LINED(8), SIX_LINED(9);

    private int value;

    public int getValue() {
        return value;
    }

    Octave(int value) {
        this.value = value;
    }
}

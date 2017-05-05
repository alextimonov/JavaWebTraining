package ua.javaweb.timonov.tasks.task05_inheritance;

/**
 * Represents musical note with english signs
 */
public enum Note {
    DO("C"), DO_SHARP("C#"), RE("D"), RE_SHARP("D#"), MI("E"), FA("F"), FA_SHARP("F#"), SOL("G"), SOL_SHARP("G#"),
    LA("A"), LA_SHARP("A#"), SI("B");

    private String sign;

    public String getSign() {
        return sign;
    }

    Note(String sign) {
        this.sign = sign;
    }
}

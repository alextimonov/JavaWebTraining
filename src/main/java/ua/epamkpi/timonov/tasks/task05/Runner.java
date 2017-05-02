package ua.epamkpi.timonov.tasks.task05;

public class Runner {
    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        Key keyCMinus1 = KeyFactory.create(Octave.SUB_SUB_CONTRA, Note.DO);
        Key keyD1 = KeyFactory.create(Octave.CONTRA, Note.RE, false);
        Key keyB2 = KeyFactory.create(Octave.GREAT, Note.SI);
        Key keyFSharp4 = KeyFactory.create(Octave.ONE_LINED, Note.FA_SHARP);

        Key anotherB2 = new Key();
        anotherB2.setOctave(Octave.GREAT);
        anotherB2.setNote(Note.SI);

        System.out.println("Before pressing key: " + keyD1);
        keyD1.press();
        System.out.println("After pressing key:  " + keyD1);

        System.out.println();

        System.out.println("Before releasing key: " + keyD1);
        keyD1.release();
        System.out.println("After releasing key:  " + keyD1);

        System.out.println();

        System.out.println("Before adjusting key: " + keyD1);
        keyD1.adjust();
        System.out.println("After adjusting key:  " + keyD1);

        System.out.println();

        System.out.println("Hashcode of " + keyCMinus1 + ": " + keyCMinus1.hashCode());
        System.out.println("Hashcode of " + keyD1 + ": " + keyD1.hashCode());
        System.out.println("Hashcode of " + keyB2 + ": " + keyB2.hashCode());
        System.out.println("Hashcode of " + keyFSharp4 + ": " + keyFSharp4.hashCode());

        System.out.println();

        System.out.println("Is " + keyD1 + "  equal\nto " + keyB2 + ": " + keyD1.equals(keyB2));
        System.out.println("Is " + keyB2 + "  equal\nto " + keyD1 + ": " + keyB2.equals(keyD1));
        System.out.println("Is " + keyB2 + "  equal\nto " + keyB2 + ": " + keyB2.equals(anotherB2));

        System.out.println();

        Piano pianoCasio = PianoFactory.create("Casio", 2010);
        Piano pianoRonisch = PianoFactory.create("Ronisch", 2000);
        Piano anotherCasio = PianoFactory.create("Casio", 2010);

        Key startKey = KeyFactory.create(Octave.SMALL, Note.LA);
        Key endKey = KeyFactory.create(Octave.TWO_LINED, Note.RE);
        Piano pianoYamaha = PianoFactory.create("Yamaha", 2015, startKey, endKey);
        pianoYamaha.getKeys().get(0).setAdjusted(false);
        pianoYamaha.getKeys().get(4).setAdjusted(false);
        pianoYamaha.getKeys().get(8).setAdjusted(false);
        pianoYamaha.getKeys().get(12).setAdjusted(false);
        pianoYamaha.getKeys().get(16).setAdjusted(false);

        System.out.println("Adjusting piano Yamaha:");
        pianoYamaha.adjust();

        System.out.println();

        System.out.println("Playing piano Casio:");
        pianoCasio.playRandomKeys(10);

        System.out.println();

        System.out.println("Hashcode of " + pianoCasio + ": " + pianoCasio.hashCode());
        System.out.println("Hashcode of " + pianoRonisch + ": " + pianoRonisch.hashCode());
        System.out.println("Hashcode of " + anotherCasio + ": " + anotherCasio.hashCode());

        System.out.println();

        System.out.println("Is " + pianoCasio + "  equal\nto " + pianoRonisch + ": " + pianoCasio.equals(pianoRonisch));
        System.out.println();
        System.out.println("Is " + pianoCasio + "  equal\nto " + anotherCasio + ": " + pianoCasio.equals(anotherCasio));
    }
}

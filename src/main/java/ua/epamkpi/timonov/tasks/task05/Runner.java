package ua.epamkpi.timonov.tasks.task05;

public class Runner {
    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        Key keyCMinus1 = KeyFactory.create(Octave.SUB_SUB_CONTRA, Note.DO);
        Key keyD1 = KeyFactory.create(Octave.CONTRA, Note.RE);
        Key keyB2 = KeyFactory.create(Octave.GREAT, Note.SI);
        Key keyFSharp4 = KeyFactory.create(Octave.ONE_LINED, Note.FA_SHARP);

        Key anotherB2 = new Key();
        anotherB2.setOctave(Octave.GREAT);
        anotherB2.setNote(Note.SI);

        keyD1.adjust();
        keyD1.press();
        keyFSharp4.adjust();
        keyFSharp4.press();

        System.out.println();

        System.out.println("Hashcode of " + keyCMinus1 + ": " + keyCMinus1.hashCode());
        System.out.println("Hashcode of " + keyD1 + ": " + keyD1.hashCode());
        System.out.println("Hashcode of " + keyB2 + ": " + keyB2.hashCode());
        System.out.println("Hashcode of " + keyFSharp4 + ": " + keyFSharp4.hashCode());

        System.out.println();

        System.out.println(keyD1 + " equals " + keyB2 + ": " + keyD1.equals(keyB2));
        System.out.println(keyB2 + " equals " + keyD1 + ": " + keyB2.equals(keyD1));
        System.out.println(keyB2 + " equals " + keyB2 + ": " + keyB2.equals(anotherB2));

        System.out.println();

        Piano pianoCasio = PianoFactory.create("Casio", 2010);
        Piano pianoRonisch = PianoFactory.create("Ronisch", 2000);
        Piano anotherCasio = PianoFactory.create("Casio", 2010);

        System.out.println("Adjusting piano:");
        pianoCasio.adjust();
        System.out.println();
        System.out.println("Playing piano:");
        pianoCasio.playRandomKeys(10);
        System.out.println();

        System.out.println("Hashcode of " + pianoCasio + ": " + pianoCasio.hashCode());
        System.out.println("Hashcode of " + pianoRonisch + ": " + pianoRonisch.hashCode());
        System.out.println("Hashcode of " + anotherCasio + ": " + anotherCasio.hashCode());

        System.out.println();

        System.out.println(pianoCasio + " equals\n" + pianoRonisch + ": " + pianoCasio.equals(pianoRonisch));
        System.out.println();
        System.out.println(pianoCasio + " equals\n" + anotherCasio + ": " + pianoCasio.equals(anotherCasio));
    }
}

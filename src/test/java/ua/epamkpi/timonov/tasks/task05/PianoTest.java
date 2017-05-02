package ua.epamkpi.timonov.tasks.task05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PianoTest {
    private Piano pianoCasio;

    private Key startKey;
    private Key endKey;
    private Piano pianoYamaha;

    @Before
    public void setUp() throws Exception {
        pianoCasio = PianoFactory.create("Casio", 2010);
        startKey = KeyFactory.create(Octave.SMALL, Note.LA);
        endKey = KeyFactory.create(Octave.TWO_LINED, Note.RE);
        pianoYamaha = PianoFactory.create("Yamaha", 2015, startKey, endKey);
    }

    @Test
    public void testAdjust() throws Exception {
        pianoYamaha.getKeys().get(2).setAdjusted(false);
        pianoYamaha.getKeys().get(5).setAdjusted(false);
        pianoYamaha.getKeys().get(9).setAdjusted(false);
        pianoYamaha.getKeys().get(11).setAdjusted(false);
        pianoYamaha.getKeys().get(15).setAdjusted(false);
        assertFalse(pianoYamaha.getKeys().get(2).isAdjusted());
        assertFalse(pianoYamaha.getKeys().get(5).isAdjusted());
        assertFalse(pianoYamaha.getKeys().get(9).isAdjusted());
        assertFalse(pianoYamaha.getKeys().get(11).isAdjusted());
        assertFalse(pianoYamaha.getKeys().get(15).isAdjusted());
        pianoYamaha.adjust();
        for (Key key : pianoYamaha.getKeys()) {
            assertTrue(key.isAdjusted());
        }
    }

    @Test
    public void testToString() throws Exception {
        String expected = "Piano {model=Yamaha, year=2015, keys\n" +
                "   from Key {SMALL          LA        ( A3 ), is pressed=false, is adjusted=true }\n     to " +
                "Key {TWO_LINED      RE        ( D5 ), is pressed=false, is adjusted=true }}";
        assertEquals(expected, pianoYamaha.toString());
    }

    @Test
    public void testEquals1() throws Exception {
        Key startKey = KeyFactory.create(Octave.SUB_SUB_CONTRA, Note.DO);
        Key endKey = KeyFactory.create(Octave.SIX_LINED, Note.SI);
        Piano anotherCasio = PianoFactory.create("Casio", 2010, startKey, endKey);
        assertEquals(anotherCasio, pianoCasio);
    }

    @Test
    public void testEquals2() throws Exception {
        startKey = KeyFactory.create(Octave.SMALL, Note.LA);
        endKey = KeyFactory.create(Octave.TWO_LINED, Note.RE);
        Piano pianoAnotherYamaha = PianoFactory.create("Yamaha", 2015, startKey, endKey);
        assertEquals(pianoAnotherYamaha, pianoYamaha);
    }
}
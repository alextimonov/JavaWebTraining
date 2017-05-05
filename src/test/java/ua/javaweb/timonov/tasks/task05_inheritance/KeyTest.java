package ua.javaweb.timonov.tasks.task05_inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class KeyTest {
    private Key key1;
    private Key key2;

    @Before
    public void setUp() throws Exception {
        key1 = new Key(Octave.SMALL, Note.DO, false);
        key2 = new Key();
    }

    @Test
    public void testPress() throws Exception {
        assertFalse(key1.isPressed());
        key1.press();
        assertTrue(key1.isPressed());
    }

    @Test
    public void testPress2() throws Exception {
        key1.setPressed(true);
        assertTrue(key1.isPressed());
        key1.press();
        assertTrue(key1.isPressed());
    }

    @Test
    public void testRelease() throws Exception {
        key1.setPressed(true);
        assertTrue(key1.isPressed());
        key1.release();
        assertFalse(key1.isPressed());
    }

    @Test
    public void testAdjust() throws Exception {
        key1.setAdjusted(false);
        assertFalse(key1.isAdjusted());
        key1.adjust();
        assertTrue(key1.isAdjusted());
    }

    @Test
    public void testAdjust2() throws Exception {
        key1.setAdjusted(true);
        assertTrue(key1.isAdjusted());
        key1.adjust();
        assertTrue(key1.isAdjusted());
    }

    @Test
    public void testEquals() throws Exception {
        key2.setOctave(Octave.SMALL);
        key2.setNote(Note.DO);
        assertEquals(key1, key2);
    }

    @Test
    public void testNotEquals() throws Exception {
        assertNotEquals(key1, key2);
    }

    @Test
    public void testHashCode1() throws Exception {
        assertEquals(52, key1.hashCode());
    }

    @Test
    public void testHashCode2() throws Exception {
        key2.setOctave(Octave.SUB_CONTRA);
        key2.setNote(Note.LA_SHARP);
        assertEquals(23, key2.hashCode());
    }

    @Test
    public void testToString1() throws Exception {
        String expected = "Key {SMALL          DO        ( C3 ), is pressed=false, is adjusted=false}";
        assertEquals(expected, key1.toString());
    }

    @Test
    public void testToString2() throws Exception {
        key2.setOctave(Octave.SUB_CONTRA);
        key2.setNote(Note.LA_SHARP);
        key2.setPressed(true);
        String expected = "Key {SUB_CONTRA     LA_SHARP  (A#0 ), is pressed=true , is adjusted=false}";
        assertEquals(expected, key2.toString());
    }
}
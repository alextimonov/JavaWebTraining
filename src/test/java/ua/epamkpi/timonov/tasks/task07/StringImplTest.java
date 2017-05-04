package ua.epamkpi.timonov.tasks.task07;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StringImplTest {

    public static final String DONG_DING_DONG = "Dong-ding-dong";
    public static final String DONG_DING_BANG = "Dong-ding-bang";
    public static final String HOW_DO_YOU_DO = "How do,you:do?I'm \"fine\"; and you? how are you?";
    public static final String DONG = "dong";
    public static final String BONG = "bong";

    private StringImpl string1;
    private StringImpl string2;
    private StringImpl string3;
    private StringImpl string4;

    @Before
    public void setUp() throws Exception {
        string1 = new StringImpl(DONG_DING_DONG);
        string2 = new StringImpl(HOW_DO_YOU_DO);
        string3 = new StringImpl();
        string4 = new StringImpl(StringImpl.DELIMITERS);
    }

    @Test
    public void testFindNumberOfLetters1() throws Exception {
        assertEquals(12, string1.findNumberOfLetters());
    }

    @Test
    public void testFindNumberOfLetters2() throws Exception {
        assertEquals(31, string2.findNumberOfLetters());
    }

    @Test
    public void testFindNumberOfLetters3() throws Exception {
        assertEquals(0, string3.findNumberOfLetters());
    }

    @Test
    public void testFindNumberOfLetters4() throws Exception {
        assertEquals(0, string4.findNumberOfLetters());
    }

    @Test
    public void testCompare1() throws Exception {
        assertTrue(string1.compareIgnoreCase(DONG_DING_DONG));
        assertFalse(string1.compareIgnoreCase(DONG_DING_BANG));
    }

    @Test
    public void testCompare2() throws Exception {
        assertTrue(string2.compareIgnoreCase(HOW_DO_YOU_DO));
        assertFalse(string2.compareIgnoreCase("How do,you:do?"));
    }

    @Test
    public void testCompare3() throws Exception {
        assertTrue(string3.compareIgnoreCase(""));
        assertFalse(string3.compareIgnoreCase(DONG_DING_DONG));
    }

    @Test
    public void testCompare4() throws Exception {
        assertFalse(string4.compareIgnoreCase(""));
        assertFalse(string4.compareIgnoreCase(DONG_DING_DONG));
    }

    @Test
    public void testToUpperCase1() throws Exception {
        assertEquals(DONG_DING_DONG.toUpperCase(), string1.toUpperCase());
        assertEquals(HOW_DO_YOU_DO.toUpperCase(), string2.toUpperCase());
        assertEquals("", string3.toUpperCase());
        assertEquals(StringImpl.DELIMITERS, string4.toUpperCase());
    }

    @Test
    public void testToLowerCase() throws Exception {
        assertEquals(DONG_DING_DONG.toLowerCase(), string1.toLowerCase());
        assertEquals(HOW_DO_YOU_DO.toLowerCase(), string2.toLowerCase());
        assertEquals("", string3.toLowerCase());
        assertEquals(StringImpl.DELIMITERS, string4.toLowerCase());
    }

    @Test
    public void testFindOccurIndexes1() throws Exception {
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 10, 11, 12, 13);
        List<Integer> actual = string1.findOccurIndexes(DONG);
        assertTrue(collectionsAreEqual(expected, actual));
    }

    @Test
    public void testFindOccurIndexes2() throws Exception {
        List<Integer> expected = Arrays.asList(7, 8, 9, 30, 31, 32, 43, 44, 45);
        List<Integer> actual = string2.findOccurIndexes("you");
        assertTrue(collectionsAreEqual(expected, actual));
    }

    @Test
    public void testFindOccurIndexes3() throws Exception {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = string3.findOccurIndexes("you");
        assertTrue(collectionsAreEqual(expected, actual));
    }

    @Test
    public void testFindOccurIndexes4() throws Exception {
        List<Integer> expected = Arrays.asList(7);
        List<Integer> actual = string4.findOccurIndexes("=");
        assertTrue(collectionsAreEqual(expected, actual));
    }

    @Test
    public void testReplace1() throws Exception {
        assertEquals("bong-ding-bong", string1.replace(DONG, BONG));
        assertEquals(DONG_DING_DONG.toLowerCase(), string1.replace(DONG, DONG));
        assertEquals("how do,he:do?i'm \"fine\"; and he? how are he?", string2.replace("you", "he"));
        assertEquals("", string3.replace("you", "he"));
        assertEquals(StringImpl.DELIMITERS, string4.replace("you", "he"));
    }

    @Test
    public void testFindEqualWords1() throws Exception {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("dong", 2);
        Map<String, Integer> actual = string1.findEqualWords();
        assertTrue(collectionsAreEqual(expected.entrySet(), actual.entrySet()));
    }

    @Test
    public void testFindEqualWords2() throws Exception {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("how", 2);
        expected.put("do", 2);
        expected.put("you", 3);
        Map<String, Integer> actual = string2.findEqualWords();
        assertTrue(collectionsAreEqual(expected.entrySet(), actual.entrySet()));
    }

    @Test
    public void testFindEqualWords3() throws Exception {
        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> actual = string3.findEqualWords();
        assertTrue(collectionsAreEqual(expected.entrySet(), actual.entrySet()));
    }

    @Test
    public void testFindEqualWords4() throws Exception {
        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> actual = string4.findEqualWords();
        assertTrue(collectionsAreEqual(expected.entrySet(), actual.entrySet()));
    }

    private <T> boolean collectionsAreEqual(Collection<T> expectedList, Collection<T> actualList) {
        Collection<T> listToCheck = new ArrayList<T>(actualList);
        for (T expectedItem : expectedList) {
            if (listToCheck.contains(expectedItem)) {
                listToCheck.remove(expectedItem);
            } else {
                return false;
            }
        }
        return listToCheck.size() == 0;
    }
}
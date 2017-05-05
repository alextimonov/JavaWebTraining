package ua.javaweb.timonov.tasks.task04_additional;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateTest {
    private Date date1;
    private Date date2;

    @Before
    public void setUp() throws Exception {
        date1 = new Date(2017, 4, 26);
        date2 = new Date();
    }

    @Test
    public void testGetDateNormal() throws Exception {
        Date newDate = date1.getDate();
        assertEquals(2017, newDate.getYear());
        assertEquals(4, newDate.getMonth());
        assertEquals(26, newDate.getDay());
    }

    @Test
    public void testGetDateBoundary() throws Exception {
        Date newDate = date2.getDate();
        assertEquals(0, newDate.getYear());
        assertEquals(0, newDate.getMonth());
        assertEquals(0, newDate.getDay());
    }

    @Test
    public void testSetDate() throws Exception {
        date2.setDate(date1);
        assertEquals(2017, date2.getYear());
        assertEquals(4, date2.getMonth());
        assertEquals(26, date2.getDay());
    }

    @Test
    public void testIsCorrectNormal1() throws Exception {
        assertTrue(date1.isCorrect());
        assertFalse(date2.isCorrect());
    }

    @Test
    public void testIsCorrectNormal2() throws Exception {
        Date date = new Date(-3, 3, 12);
        assertFalse(date.isCorrect());
    }

    @Test
    public void testIsCorrectNormal3() throws Exception {
        Date date = new Date(2000, 0, 12);
        assertFalse(date.isCorrect());
    }

    @Test
    public void testIsCorrectNormal4() throws Exception {
        Date date = new Date(2000, 13, 15);
        assertFalse(date.isCorrect());
    }

    @Test
    public void testIsCorrectNormal5() throws Exception {
        Date date = new Date(2000, 5, 0);
        assertFalse(date.isCorrect());
    }

    @Test
    public void testIsCorrectNormal6() throws Exception {
        Date date = new Date(2000, 4, 31);
        assertFalse(date.isCorrect());
    }

    @Test
    public void testIsCorrectNormal7() throws Exception {
        Date date = new Date(2017, 2, 28);
        assertTrue(date.isCorrect());
        date.setDay(29);
        assertFalse(date.isCorrect());
    }

    @Test
    public void testIsCorrectBoundary1() throws Exception {
        Date date = new Date(2100, 2, 29);
        assertFalse(date.isCorrect());
        date.setYear(2000);
        assertTrue(date.isCorrect());
    }

    @Test
    public void testCompareTo() throws Exception {
        Date dateLess = new Date(2017, 3, 31);
        Date dateMore = new Date(2017, 5, 1);
        assertTrue(date1.compareTo(dateLess) > 0);
        assertTrue(date1.compareTo(dateMore) < 0);
        assertTrue(date1.compareTo(new Date(2017, 4, 26)) == 0);
    }

    @Test
    public void testCreateOutput() throws Exception {
        assertEquals("26.04.2017", date1.toString());
        assertEquals("00.00.0000", date2.toString());
    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertFalse(date1.isLeapYear());
        Date date = new Date(2000, 1, 1);
        assertTrue(date.isLeapYear());
        date.setYear(2100);
        assertFalse(date.isLeapYear());
        date.setYear(2400);
        assertTrue(date.isLeapYear());
    }

    @Test
    public void testIncreaseByNumberOfDays() throws Exception {
        date1.increaseByNumberOfDays(2);
        assertTrue(date1.equals(new Date(2017, 4, 28)));
        date1.increaseByNumberOfDays(12);
        assertTrue(date1.equals(new Date(2017, 5, 10)));
        date1.increaseByNumberOfDays(365 + 31);
        assertTrue(date1.equals(new Date(2018, 6, 10)));
    }

    @Test
    public void testDecreaseByNumberOfDays() throws Exception {
        date1.decreaseByNumberOfDays(21);
        assertTrue(date1.equals(new Date(2017, 4, 5)));
        date1.decreaseByNumberOfDays(12);
        assertTrue(date1.equals(new Date(2017, 3, 24)));
        date1.decreaseByNumberOfDays(365 + 31);
        assertTrue(date1.equals(new Date(2016, 2, 22)));
    }

    @Test
    public void testIncreaseByNumberOfMonths() throws Exception {
        date1.increaseByNumberOfMonths(4);
        assertTrue(date1.equals(new Date(2017, 8, 26)));
        date1.increaseByNumberOfMonths(30);
        assertTrue(date1.equals(new Date(2020, 2, 26)));
    }

    @Test
    public void testIncreaseByNumberOfMonthsBoundary() throws Exception {
        Date date = new Date(2017, 3, 31);
        date.increaseByNumberOfMonths(3);
        assertTrue(date.equals(new Date(2017, 6, 30)));
    }

    @Test
    public void testDecreaseByNumberOfMonths() throws Exception {
        date1.decreaseByNumberOfMonths(3);
        assertTrue(date1.equals(new Date(2017, 1, 26)));
        date1.decreaseByNumberOfMonths(30);
        assertTrue(date1.equals(new Date(2014, 7, 26)));
    }

    @Test
    public void testDecreaseByNumberOfMonthsBoundary() throws Exception {
        Date date = new Date(2016, 9, 31);
        date.decreaseByNumberOfMonths(7);
        assertTrue(date.equals(new Date(2016, 2, 29)));
    }

    @Test
    public void testIncreaseByNumberOfYears() throws Exception {
        date1.increaseByNumberOfYears(2);
        assertTrue(date1.equals(new Date(2019, 4, 26)));
        date1.increaseByNumberOfYears(10);
        assertTrue(date1.equals(new Date(2029, 4, 26)));
    }

    @Test
    public void testIncreaseByNumberOfYearsBoundary() throws Exception {
        Date date = new Date(2016, 2, 29);
        date.increaseByNumberOfYears(3);
        assertTrue(date.equals(new Date(2019, 2, 28)));
    }

    @Test
    public void testDecreaseByNumberOfYears() throws Exception {
        date1.decreaseByNumberOfYears(2);
        assertTrue(date1.equals(new Date(2015, 4, 26)));
        date1.decreaseByNumberOfYears(10);
        assertTrue(date1.equals(new Date(2005, 4, 26)));
    }

    @Test
    public void testDecreaseByNumberOfYearsBoundary() throws Exception {
        Date date = new Date(2016, 2, 29);
        date.decreaseByNumberOfYears(3);
        assertTrue(date.equals(new Date(2013, 2, 28)));
    }

    @Test
    public void testIncreaseByDaysMonthsYears() throws Exception {
        date1.increaseByYearsMonthsDays(1, 4, 1);
        assertTrue(date1.equals(new Date(2018, 8, 27)));
        date1.increaseByYearsMonthsDays(2, 6, 6);
        assertTrue(date1.equals(new Date(2021, 3, 5)));
    }

    @Test
    public void testDecreaseByDaysMonthsYears() throws Exception {
        date1.decreaseByYearsMonthsDays(1, 2, 21);
        assertTrue(date1.equals(new Date(2016, 2, 5)));
        date1.decreaseByYearsMonthsDays(2, 6, 10);
        assertTrue(date1.equals(new Date(2013, 7, 26)));
    }

    @Test
    public void testFindNumberOfFullMonths1() throws Exception {
        Date date = new Date(2017, 9, 1);
        assertEquals(4, date1.findNumberOfFullMonths(date));
        assertEquals(4, date.findNumberOfFullMonths(date1));
    }

    @Test
    public void testFindNumberOfFullMonths2() throws Exception {
        Date date = new Date(2025, 1, 1);
        assertEquals(8 + 7 * 12, date1.findNumberOfFullMonths(date));
        assertEquals(8 + 7 * 12, date.findNumberOfFullMonths(date1));
    }

    @Test
    public void testFindNumberOfFullYears1() throws Exception {
        Date date = new Date(2025, 1, 1);
        assertEquals(7, date1.findNumberOfFullYears(date));
        assertEquals(7, date.findNumberOfFullYears(date1));
    }

    @Test
    public void testFindNumberOfFullYears2() throws Exception {
        Date date = new Date(1, 1, 1);
        assertEquals(2016, date1.findNumberOfFullYears(date));
        assertEquals(2016, date.findNumberOfFullYears(date1));
    }
}
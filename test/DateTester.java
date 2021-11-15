package test;

import src.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DateTester {

    @Test
    public void testCompareToEquals() {
        Date d1 = new Date(1, 2, 3);
        Date d2 = new Date(1, 2, 3);
        assertEquals(0, d1.compareTo(d2));
    }

    @Test
    public void testCompareToDayLess() {
        Date d1 = new Date(1, 4, 6);
        Date d2 = new Date(2, 4, 6);
        assertEquals(-1, d1.compareTo(d2));
    }

    @Test
    public void testCompareToDayMore() {
        Date d1 = new Date(2, 4, 6);
        Date d2 = new Date(1, 4, 6);
        assertEquals(1, d1.compareTo(d2));
    }

    @Test
    public void testCompareToMonthLess() {
        Date d1 = new Date(3, 3, 6);
        Date d2 = new Date(2, 4, 6);
        assertEquals(-1, d1.compareTo(d2));
    }

    @Test
    public void testCompareToMonthMore() {
        Date d1 = new Date(1, 5, 6);
        Date d2 = new Date(2, 4, 6);
        assertEquals(1, d1.compareTo(d2));
    }

    @Test
    public void testCompareToYearLess() {
        Date d1 = new Date(3, 7, 6);
        Date d2 = new Date(2, 4, 60);
        assertEquals(-1, d1.compareTo(d2));
    }

    @Test
    public void testCompareToYearMore() {
        Date d1 = new Date(1, 2, 600);
        Date d2 = new Date(2, 4, 60);
        assertEquals(1, d1.compareTo(d2));
    }

    @Test
    public void testEqualsDateFalse() {
        Date d1 = new Date(1, 2, 600);
        Date d2 = new Date(1, 2, 60);
        assertEquals(false, d1.equals(d2));
    }

    @Test
    public void testEqualsDateTrue() {
        Date d1 = new Date(1, 2, 600);
        Date d2 = new Date(1, 2, 600);
        assertEquals(true, d1.equals(d2));
    }

    @Test
    public void testEqualsDatePointer() {
        Date d1 = new Date(1, 2, 600);
        Date d2 = d1;
        assertEquals(true, d1.equals(d2));
    }

    @Test
    public void testEarlyToString() {
        Date d1 = new Date(1, 2, 600);
        assertEquals("01/02/600", d1.toString());
    }

    @Test
    public void testLateToString() {
        Date d1 = new Date(11, 12, 600);
        assertEquals("11/12/600", d1.toString());
    }
}

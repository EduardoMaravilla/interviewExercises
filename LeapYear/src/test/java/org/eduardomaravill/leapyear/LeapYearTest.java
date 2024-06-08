package org.eduardomaravill.leapyear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {

    private  LeapYear leapYear;

    @BeforeEach
    void setUp() {
        leapYear = new LeapYear();
    }

    @Test
    @DisplayName("Leap year test")
    void isLeapYear() {
        assertTrue(leapYear.isLeapYear(2000));
        assertTrue(leapYear.isLeapYear(2016));
        assertTrue(leapYear.isLeapYear(2020));
        assertTrue(leapYear.isLeapYear(2024));
        assertTrue(leapYear.isLeapYear(2028));
        assertTrue(leapYear.isLeapYear(2032));
        assertTrue(leapYear.isLeapYear(2036));
        assertTrue(leapYear.isLeapYear(2040));
        assertTrue(leapYear.isLeapYear(2044));
        assertTrue(leapYear.isLeapYear(2048));
        assertTrue(leapYear.isLeapYear(2052));
    }

    @Test
    @DisplayName("Not leap year test")
    void isNotLeapYear() {
        assertFalse(leapYear.isLeapYear(2001));
        assertFalse(leapYear.isLeapYear(2002));
        assertFalse(leapYear.isLeapYear(2003));
        assertFalse(leapYear.isLeapYear(2005));
        assertFalse(leapYear.isLeapYear(2006));
        assertFalse(leapYear.isLeapYear(2007));
        assertFalse(leapYear.isLeapYear(2009));
        assertFalse(leapYear.isLeapYear(2010));
        assertFalse(leapYear.isLeapYear(2011));
    }

    @ParameterizedTest
    @DisplayName("Leap year parametrized test")
    @CsvSource({"2000","2016"})
    void isLeapYearParametrized(int year) {
        assertTrue(leapYear.isLeapYear(year));
    }
}
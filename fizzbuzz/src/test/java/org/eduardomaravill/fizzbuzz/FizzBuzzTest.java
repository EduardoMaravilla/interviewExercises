package org.eduardomaravill.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Test multiple of three")
    void multipleOfThreeTest() {
        assertEquals("Fizz", fizzBuzz.convert(3));
        assertEquals("Fizz", fizzBuzz.convert(6));
        assertEquals("Fizz", fizzBuzz.convert(9));
        assertEquals("Fizz", fizzBuzz.convert(12));
        assertEquals("Fizz", fizzBuzz.convert(18));
    }

    @Test
    @DisplayName("Test multiple of five")
    void multipleOfFiveTest() {
        assertEquals("Buzz", fizzBuzz.convert(5));
        assertEquals("Buzz", fizzBuzz.convert(10));
        assertEquals("Buzz", fizzBuzz.convert(20));
        assertEquals("Buzz", fizzBuzz.convert(25));
        assertEquals("Buzz", fizzBuzz.convert(50));
    }

    @Test
    @DisplayName("Test multiple of three and five")
    void multipleOfThreeAndFiveTest() {
        assertEquals("FizzBuzz", fizzBuzz.convert(15));
        assertEquals("FizzBuzz", fizzBuzz.convert(30));
        assertEquals("FizzBuzz", fizzBuzz.convert(45));
        assertEquals("FizzBuzz", fizzBuzz.convert(60));
        assertEquals("FizzBuzz", fizzBuzz.convert(90));
    }

    @Test
    @DisplayName("Test all numbers")
    void convertAll() {
        assertEquals("1", fizzBuzz.convert(1));
        assertEquals("2", fizzBuzz.convert(2));
        assertEquals("Fizz", fizzBuzz.convert(3));
        assertEquals("4", fizzBuzz.convert(4));
        assertEquals("Buzz", fizzBuzz.convert(5));
        assertEquals("Fizz", fizzBuzz.convert(6));
        assertEquals("7", fizzBuzz.convert(7));
        assertEquals("8", fizzBuzz.convert(8));
        assertEquals("Fizz", fizzBuzz.convert(9));
        assertEquals("Buzz", fizzBuzz.convert(10));
        assertEquals("11", fizzBuzz.convert(11));
        assertEquals("Fizz", fizzBuzz.convert(12));
        assertEquals("13", fizzBuzz.convert(13));
        assertEquals("14", fizzBuzz.convert(14));
        assertEquals("FizzBuzz", fizzBuzz.convert(15));
    }

    @Test
    @DisplayName("Test array numbers")
    void allArrayNumbersTest() {
        assertEquals("""
                1
                2
                Fizz
                4
                Buzz
                Fizz
                7
                8
                Fizz
                Buzz
                11
                Fizz
                13
                14
                FizzBuzz""",fizzBuzz.convertAll(15));
    }

    @DisplayName("Test parametrized")
    @ParameterizedTest
    @CsvSource({"1, 1",
            "2, 2",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            "30, FizzBuzz",
            "7, 7"})
    void testParametrized(int num, String expected){
        assertEquals(expected,fizzBuzz.convert(num));
    }

    @DisplayName("Test parametrized file")
    @ParameterizedTest
    @CsvFileSource(resources = "/cvs/fizzbuzz.csv", numLinesToSkip = 0)
    void testParametrizedFile(int num, String expected) {
        assertEquals(expected, fizzBuzz.convert(num));
    }
}
package com.incubyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    // 1. Empty String
    @Test
    void emptyStringShouldReturnZero() {
        assertEquals(0, calculator.add(""));
    }

    // 2. Single Number
    @Test
    void singleNumberShouldReturnItself() {
        assertEquals(5, calculator.add("5"));
    }

    // 3. Two Numbers
    @Test
    void twoNumbersShouldReturnSum() {
        assertEquals(8, calculator.add("3,5"));
    }

    // 4. Multiple Numbers
    @Test
    void multipleNumbersShouldReturnSum() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    // 5. Handle Newline as Delimiter
    @Test
    void numbersWithNewlineDelimiterShouldReturnSum() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    // 6. Custom Delimiter with Single Character
    @Test
    void customDelimiterShouldBeSupported() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    // 7. Custom Delimiter with Different Symbol
    @Test
    void customDelimiterHashShouldWork() {
        assertEquals(10, calculator.add("//#\n2#3#5"));
    }

    // 8. Negative Number Throws Exception
    @Test
    void singleNegativeNumberShouldThrowException() {
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> calculator.add("-2"));
        assertTrue(ex.getMessage().contains("negative numbers not allowed -2"));
    }

    // 9. Multiple Negative Numbers Show All
    @Test
    void multipleNegativeNumbersShouldShowAllInException() {
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> calculator.add("1,-2,3,-5"));
        assertTrue(ex.getMessage().contains("negative numbers not allowed -2,-5"));
    }

    // 10. Ignore Numbers Greater Than 1000 (Optional Bonus)
    @Test
    void numbersGreaterThanThousandShouldBeIgnored() {
        assertEquals(2, calculator.add("2,1001"));
    }

    // 11. Custom Multi-character Delimiter (Optional Bonus)
    @Test
    void multiCharacterDelimiterShouldBeSupported() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    // 12. Multiple Delimiters (Optional Bonus)
    @Test
    void multipleDelimitersShouldBeSupported() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }
}

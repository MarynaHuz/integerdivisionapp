package com.javajungle.calculator;

import com.javajungle.calculator.model.DivisionStep;
import com.javajungle.calculator.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    void divide_shouldReturnResultWhichIsEqualToExpected_whenItGetsTwoNumbersThatAreGreaterThanZero() {
        Result expected = new Result(33, 2, 16, 1,
                Arrays.asList(new DivisionStep(3, 2, 1, 1),
                        new DivisionStep(13, 12, 1, 6)));
        Result actual = calculator.divide(33, 2);
        assertEquals(expected, actual);
    }

    @Test
    void divide_shouldReturnResultWhichIsEqualToExpected_whenItGetsLargeDividendAndSmallDivisor() {
        Result expected = new Result(78945, 4, 19736, 1,
                Arrays.asList(
                        new DivisionStep(7, 4, 3, 1),
                        new DivisionStep(38, 36, 2, 9),
                        new DivisionStep(29, 28, 1, 7),
                        new DivisionStep(14, 12, 2, 3),
                        new DivisionStep(25, 24, 1, 6)
                ));
        Result actual = calculator.divide(78945, 4);
        assertEquals(expected, actual);
    }

    @Test
    void divide_shouldReturnResultWhichIsEqualToExpected_whenDividendContainsManyZerosAndAndRemainderEqualsZero() {
        Result expected = new Result(1000100010, 10, 100010001, 0,
                Arrays.asList(
                        new DivisionStep(10, 10, 0, 1),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(1, 0, 1, 0),
                        new DivisionStep(10, 10, 0, 1),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(1, 0, 1, 0),
                        new DivisionStep(10, 10, 0, 1)
                ));
        Result actual = calculator.divide(1000100010, 10);
        assertEquals(expected, actual);
    }


    @Test
    void divide_shouldReturnResultWhichIsEqualToExpected_whenDifferenceAndSubtrahendAreEqual() {
        Result expected = new Result(123, 12, 10, 3,
                Arrays.asList(
                        new DivisionStep(12, 12, 0, 1),
                        new DivisionStep(3, 0, 3, 0)
                ));
        Result actual = calculator.divide(123, 12);
        assertEquals(expected, actual);
    }

    @Test
    void divide_shouldReturnResultWhichIsEqualToExpected_whenDividendContainsManyZerosAndHasRemainder() {
        Result expected = new Result(1000010001, 10, 100001000, 1,
                Arrays.asList(
                        new DivisionStep(10, 10, 0, 1),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(1, 0, 1, 0),
                        new DivisionStep(10, 10, 0, 1),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(0, 0, 0, 0),
                        new DivisionStep(1, 0, 1, 0)
                ));
        Result actual = calculator.divide(1000010001, 10);
        assertEquals(expected, actual);
    }

    @Test
    void divide_shouldReturnIllegalArgumentException_WhenDividendIsEqualOrLessThanZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(-12543, 7));
        assertEquals("Dividend has to be greater than zero", exception.getMessage());
    }

    @Test
    void divide_shouldReturnIllegalArgumentException_WhenDivisorEqualsZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(12543, 0));
        assertEquals("Division  by zero is undefined", exception.getMessage());
    }

    @Test
    void divide_shouldReturnResultWhichIsEqualToExpected_whenDivisorIsLessThanZero() {
        Result expected = new Result(12543, -7, -1791, 6,
                Arrays.asList(
                        new DivisionStep(12, 7, 5, -1),
                        new DivisionStep(55, 49, 6, -7),
                        new DivisionStep(64, 63, 1, -9),
                        new DivisionStep(13, 7, 6, -1)
                ));
        Result actual = calculator.divide(12543, -7);
        assertEquals(expected, actual);
    }
}
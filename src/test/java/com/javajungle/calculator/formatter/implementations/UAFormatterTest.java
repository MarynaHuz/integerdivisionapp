package com.javajungle.calculator.formatter.implementations;

import com.javajungle.calculator.model.DivisionStep;
import com.javajungle.calculator.model.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import com.javajungle.calculator.formatter.Formatter;

import static org.junit.jupiter.api.Assertions.*;

class UAFormatterTest {

    Formatter formatter = new UAFormatter();

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenIndentIncreasesByOneWithEachDivisionStep() {
        String expected =
                """
                        _78945|4
                         4    |-----
                         -    |19736
                        _38
                         36
                         --
                         _29
                          28
                          --
                          _14
                           12
                           --
                           _25
                            24
                            --
                             1
                        """;

        Result input = new Result(78945, 4, 19736, 1,
                Arrays.asList(
                        new DivisionStep(7, 4, 3, 1),
                        new DivisionStep(38, 36, 2, 9),
                        new DivisionStep(29, 28, 1, 7),
                        new DivisionStep(14, 12, 2, 3),
                        new DivisionStep(25, 24, 1, 6)
                ));
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenDividendContainsManyZerosAndRemainderEqualsZero() {
        String expected =
                """
                        _1000100010|10
                         10        |---------
                         --        |100010001
                            _10
                             10
                             --
                                _10
                                 10
                                 --
                                  0
                        """;

        Result input = new Result(1000100010, 10, 100010001, 0,
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
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }


    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenLengthOfSubtrahendIsSmallerThanLengthOfDifference() {
        String expected =
                """
                        _12543|7
                          7   |----
                          -   |1791
                         _55
                          49
                          --
                          _64
                           63
                           --
                           _13
                             7
                             -
                             6
                        """;

        Result input = new Result(12543, 7, 1791, 6,
                Arrays.asList(
                        new DivisionStep(12, 7, 5, 1),
                        new DivisionStep(55, 49, 6, 7),
                        new DivisionStep(64, 63, 1, 9),
                        new DivisionStep(13, 7, 6, 1)
                ));
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenIndentIsDifferentOnEachDivisionStep() {
        String expected =
                """
                        _7544333|685
                         685    |-----
                         ---    |11013
                         _694
                          685
                          ---
                           _933
                            685
                            ---
                           _2483
                            2055
                            ----
                             428
                        """;

        Result input = new Result(7544333, 685, 11013, 428,
                Arrays.asList(
                        new DivisionStep(754, 685, 69, 1),
                        new DivisionStep(694, 685, 9, 1),
                        new DivisionStep(93, 0, 93, 0),
                        new DivisionStep(933, 685, 248, 1),
                        new DivisionStep(2483, 2055, 428, 3)
                ));
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenDivisorIsGraterThanQuotient() {
        String expected =
                """
                        _786944|4678
                         4678  |----
                         ----  |168
                        _31914
                         28068
                         -----
                         _38464
                          37424
                          -----
                           1040
                        """;

        Result input = new Result(786944, 4678, 168, 1040,
                Arrays.asList(
                        new DivisionStep(7869, 4678, 3191, 1),
                        new DivisionStep(31914, 28068, 3846, 6),
                        new DivisionStep(38464, 37424, 1040, 8)
                ));
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenDivisionHasTwoStepsAndHasRemainder() {
        String expected =
                """
                        _123|12
                         12 |--
                         -- |10
                           3
                        """;

        Result input = new Result(123, 12, 10, 3,
                Arrays.asList(
                        new DivisionStep(12, 12, 0, 1),
                        new DivisionStep(3, 0, 3, 0)
                ));
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenDividendContainsManyZerosAndHasRemainder() {
        String expected =
                """
                        _1000010001|10
                         10        |---------
                         --        |100001000
                             _10
                              10
                              --
                                  1
                        """;

        Result input = new Result(1000010001, 10, 100001000, 1,
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
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenLengthOfSubtrahendIsSmallerThanLengthOfDifferenceAndDivisorIsNegative() {
        String expected =
                """
                        _12543|-7
                          7   |-----
                          -   |-1791
                         _55
                          49
                          --
                          _64
                           63
                           --
                           _13
                             7
                             -
                             6
                        """;

        Result input = new Result(12543, -7, -1791, 6,
                Arrays.asList(
                        new DivisionStep(12, 7, 5, -1),
                        new DivisionStep(55, 49, 6, -7),
                        new DivisionStep(64, 63, 1, -9),
                        new DivisionStep(13, 7, 6, -1)
                ));
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }
}
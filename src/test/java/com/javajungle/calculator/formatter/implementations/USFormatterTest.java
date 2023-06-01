package com.javajungle.calculator.formatter.implementations;

import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.model.DivisionStep;
import com.javajungle.calculator.model.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class USFormatterTest {

    Formatter formatter = new USFormatter();

    @Test
    void format_shouldReturnResultWhichIsEqualToExpected_whenIndentIncreasesByOneWithEachDivisionStep() {
        String expected =
                """
                          19736
                         ------
                        4|78945
                          4
                          -
                          38
                          36
                          --
                           29
                           28
                           --
                            14
                            12
                            --
                             25
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
                            100010001
                          -----------
                        10|1000100010
                           10
                           --
                               10
                               10
                               --
                                   10
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
                           1791
                         ------
                        7|12543
                           7
                           -
                           55
                           49
                           --
                            64
                            63
                            --
                             13
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
                              11013
                           --------
                        685|7544333
                            685
                            ---
                             694
                             685
                             ---
                               933
                               685
                               ---
                               2483
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
                                168
                            -------
                        4678|786944
                             4678
                             ----
                             31914
                             28068
                             -----
                              38464
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
                            10
                          ----
                        12|123
                           12
                           --
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
                            100001000
                          -----------
                        10|1000010001
                           10
                           --
                                10
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
                           -1791
                          ------
                        -7|12543
                            7
                            -
                            55
                            49
                            --
                             64
                             63
                             --
                              13
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
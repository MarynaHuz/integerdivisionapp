package com.javajungle.calculator;

import com.javajungle.calculator.model.DivisionStep;
import com.javajungle.calculator.model.Result;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Result divide(int dividend, int divisor) {

        validate(dividend, divisor);

        int quotient = dividend / divisor;
        int reminder = dividend % divisor;
        int[] dividendDigits = splitDividendByDigits(dividend);

        List<DivisionStep> divisionSteps = new ArrayList<>(calculateDivisionSteps(dividendDigits, divisor));

        return new Result(dividend, divisor, quotient, reminder, divisionSteps);
    }

    private static void validate(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division  by zero is undefined");
        } else if (dividend <= 0) {
            throw new IllegalArgumentException("Dividend has to be greater than zero");
        }
    }


    private List<DivisionStep> calculateDivisionSteps(int[] dividendDigits, int divisor) {
        List<DivisionStep> divisionSteps = new ArrayList<>();
        int difference = 0;
        int i = 0;

        while (i < dividendDigits.length) {

            difference = difference * 10 + dividendDigits[i];

            if (difference >= Math.abs(divisor)) {

                int quotientDigit = difference / divisor;
                int subtrahend = quotientDigit * divisor;
                int remainder = difference - subtrahend;

                divisionSteps.add(new DivisionStep(difference, subtrahend, remainder, quotientDigit));

                difference = remainder;

            } else if (!divisionSteps.isEmpty()) {
                divisionSteps.add(new DivisionStep(difference, 0, difference, 0));
            }

            i++;
        }

        return divisionSteps;
    }

    private int[] splitDividendByDigits(int dividend) {
        String dividendString = String.valueOf(dividend);
        int[] dividendDigits = new int[dividendString.length()];

        for (int i = 0; i < dividendString.length(); i++) {
            char num = dividendString.charAt(i);
            int digit = Character.getNumericValue(num);
            dividendDigits[i] = digit;
        }
        return dividendDigits;
    }
}

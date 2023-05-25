package com.javajungle.calculator;

import com.javajungle.calculator.model.DivisionStep;
import com.javajungle.calculator.model.Result;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Result divide(int dividend, int divisor) {

        validate(divisor);
        int quotient = dividend / divisor;
        int reminder = dividend % divisor;
        int[] dividendDigits = convertDividendToIntArray(dividend);

        List<DivisionStep> divisionSteps = new ArrayList<>(getDivisionSteps(dividendDigits, divisor));

        return new Result(dividend, divisor, quotient, reminder, divisionSteps);
    }


    private static void validate(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division  by zero is undefined");
        }
    }

    private List<DivisionStep> getDivisionSteps(int[] dividendDigits, int divisor) {
        int multiplyResult;
        List<DivisionStep> divisionSteps = new ArrayList<>();
        int mod = dividendDigits[0];
        int i = 1;

        while (i <= dividendDigits.length) {
            while (mod < divisor && i < dividendDigits.length) {
                mod = mod * 10 + dividendDigits[i];
                i++;
            }
            multiplyResult = mod / divisor * divisor;
            divisionSteps.add(new DivisionStep(mod, multiplyResult));
            mod = (mod - multiplyResult) * 10 + (i < dividendDigits.length ? dividendDigits[i] : 0);
            i++;
        }
        return divisionSteps;
    }

    private int[] convertDividendToIntArray(int dividend) {
        String dividendString = String.valueOf(dividend);
        int[] dividendNums = new int[dividendString.length()];

        for (int i = 0; i < dividendString.length(); i++) {
            char num = dividendString.charAt(i);
            int digit = Character.getNumericValue(num);
            dividendNums[i] = digit;
        }
        return dividendNums;
    }
}

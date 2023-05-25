package com.javajungle.calculator.model;

import java.util.List;
import java.util.Objects;

public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int reminder;
    private final List<DivisionStep> divisionSteps;

    public Result(int dividend, int divisor, int quotient, int reminder, List<DivisionStep> divisionSteps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.reminder = reminder;
        this.divisionSteps = divisionSteps;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getReminder() {
        return reminder;
    }

    public List<DivisionStep> getDivisionSteps() {
        return divisionSteps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result result)) return false;
        return dividend == result.dividend && divisor == result.divisor && quotient == result.quotient && reminder == result.reminder && Objects.equals(divisionSteps, result.divisionSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, quotient, reminder, divisionSteps);
    }

    @Override
    public String toString() {
        return "Result{" +
                "dividend=" + dividend +
                ", divisor=" + divisor +
                ", quotient=" + quotient +
                ", reminder=" + reminder +
                ", divisionSteps=" + divisionSteps +
                '}';
    }
}

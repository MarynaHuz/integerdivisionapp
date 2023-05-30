package com.javajungle.calculator.model;

import java.util.List;
import java.util.Objects;

public record Result(int dividend, int divisor, int quotient, int reminder, List<DivisionStep> divisionSteps) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result result)) return false;
        return dividend == result.dividend && divisor == result.divisor && quotient == result.quotient && reminder == result.reminder && Objects.equals(divisionSteps, result.divisionSteps);
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%d,%d,%s", dividend, divisor, quotient, reminder, divisionSteps);
    }
}

package com.javajungle.calculator.model;

public record DivisionStep(int difference, int subtrahend, int remainderAfterEachStep, int quotientDigit) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DivisionStep that)) return false;
        return difference == that.difference && subtrahend == that.subtrahend && remainderAfterEachStep == that.remainderAfterEachStep && quotientDigit == that.quotientDigit;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%d,%d", difference, subtrahend, remainderAfterEachStep, quotientDigit);
    }
}

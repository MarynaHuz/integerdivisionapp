package com.javajungle.calculator.model;

import java.util.Objects;

public class DivisionStep {

    private final int mod;
    private final int multiplyResult;

    public DivisionStep(int mod, int multiplyResult) {
        this.mod = mod;
        this.multiplyResult = multiplyResult;
    }

    public int getMultiplyResult() {
        return multiplyResult;
    }

    public int getMod() {
        return mod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DivisionStep that)) return false;
        return mod == that.mod && multiplyResult == that.multiplyResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mod, multiplyResult);
    }

    @Override
    public String toString() {
        return "{" +
                 mod + ","+
                 multiplyResult +
                '}';
    }
}

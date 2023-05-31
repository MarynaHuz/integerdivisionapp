package com.javajungle.calculator.formatter.implementations;

import com.javajungle.calculator.formatter.Formatter;

public abstract class AbstractFormatter implements Formatter {

    protected static int calculateStepIndent(int indent, int difference, int subtrahend) {
        if (getLengthOfNumber(subtrahend) < getLengthOfNumber(difference)) {
            return indent + calculateIndent(difference, subtrahend);
        }
        return indent;
    }

    protected static int calculateIndent(int firstNumber, int secondNumber) {
        return getLengthOfNumber(firstNumber) - getLengthOfNumber(secondNumber);
    }

    protected static int getLengthOfNumber(int number) {
        return String.valueOf(number).length();
    }

}

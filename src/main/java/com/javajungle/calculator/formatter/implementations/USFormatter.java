package com.javajungle.calculator.formatter.implementations;

import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.model.Result;

public class USFormatter extends AbstractFormatter implements Formatter {

       @Override
    public String format(Result result) {

           StringBuilder output = new StringBuilder();
           int indent = getLengthOfNumber(result.divisor()) + 1;

        output.append(String.format(" %s%d\n", " ".repeat(getLengthOfNumber(result.dividend()) +
                getLengthOfNumber(result.divisor()) - getLengthOfNumber(result.quotient())), result.quotient()));

        output.append(String.format("%s%s\n", " ".repeat(getLengthOfNumber(result.divisor())),
                "-".repeat(Math.max(getLengthOfNumber(result.quotient()), getLengthOfNumber(result.dividend()) + 1))));

        output.append(String.format("%d|%d\n", result.divisor(), result.dividend()));


        int i = 0;
        while (i < result.divisionSteps().size()) {

            int difference = result.divisionSteps().get(i).difference();
            int subtrahend = result.divisionSteps().get(i).subtrahend();
            int remainderAfterEachStep = result.divisionSteps().get(i).remainderAfterEachStep();
            int quotientDigit = result.divisionSteps().get(i).quotientDigit();
            int stepIndent = calculateStepIndent(indent, difference, subtrahend);

            if (subtrahend == 0 && quotientDigit <= 0) {
                indent = indent + 1;
            }

            if (difference != 0 && subtrahend != 0) {
                if (i == 0) {
                    indent = calculateStepIndent(indent, difference, subtrahend);
                }
                if (i != 0) {
                    output.append(String.format("%s%d\n", " ".repeat(indent), difference));
                }

                output.append(String.format("%s%d\n", " ".repeat(stepIndent), subtrahend));
                output.append(String.format("%s%s\n", " ".repeat(stepIndent), "-".repeat(getLengthOfNumber(subtrahend))));
            }

            indent = indent + calculateIndent(subtrahend, remainderAfterEachStep);

            if (i + 1 == result.divisionSteps().size()) {
                output.append(String.format("%s%d\n", " ".repeat(calculateStepIndent(indent, difference, subtrahend)), result.reminder()));
            }
            i++;
        }
        return output.toString();
    }
}
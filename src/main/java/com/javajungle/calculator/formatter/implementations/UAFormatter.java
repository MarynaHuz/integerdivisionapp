package com.javajungle.calculator.formatter.implementations;


import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.model.Result;

public class UAFormatter extends AbstractFormatter implements Formatter {

    @Override
    public String format(Result result) {

        StringBuilder output = new StringBuilder();
        int firstDifference = result.divisionSteps().get(0).difference();
        int firstSubtrahend = result.divisionSteps().get(0).subtrahend();
        int indent = calculateIndent(firstDifference, result.divisionSteps().get(0).remainderAfterEachStep()) + 1;

        output.append(String.format("_%d|%d\n", result.dividend(), result.divisor()));

        output.append(String.format(" %s%d%s|%s\n",
                " ".repeat(calculateIndent(firstDifference, firstSubtrahend)), firstSubtrahend,
                " ".repeat(calculateIndent(result.dividend(), firstDifference)),
                "-".repeat(Math.max(getLengthOfNumber(result.quotient()), getLengthOfNumber(result.divisor())))));

        output.append(String.format(" %s%s%s|%d\n", " ".repeat(calculateIndent(firstDifference, firstSubtrahend)),
                "-".repeat(getLengthOfNumber(firstSubtrahend)), " ".repeat(calculateIndent(result.dividend(), firstDifference)), result.quotient()));


        int i = 1;
        while (i < result.divisionSteps().size()) {

            int difference = result.divisionSteps().get(i).difference();
            int subtrahend = result.divisionSteps().get(i).subtrahend();
            int remainderAfterEachStep = result.divisionSteps().get(i).remainderAfterEachStep();
            int quotientDigit = result.divisionSteps().get(i).quotientDigit();
            int stepIndent = calculateStepIndent(indent, difference, subtrahend);

            if (subtrahend == 0 && quotientDigit == 0) {
                indent = indent + 1;
            }

            if (difference != 0 && subtrahend != 0) {
                output.append(String.format("%s_%d\n", " ".repeat(indent - 1), difference));
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
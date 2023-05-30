package com.javajungle.calculator.formatter.implementations;


import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.model.Result;

public class UAFormatter implements Formatter {


    @Override
    public String format(Result result) {

        StringBuilder output = new StringBuilder();
        int dividend = result.dividend();
        int firstDifference = result.divisionSteps().get(0).difference();
        int firstSubtrahend = result.divisionSteps().get(0).subtrahend();
        int quotient = result.quotient();
        int divisor = result.divisor();
        int indent = calculateIndent(firstDifference, result.divisionSteps().get(0).remainderAfterEachStep()) + 1;


        output.append(String.format("_%d|%d\n", dividend, result.divisor()));

        output.append(String.format(" %s%d%s|%s\n", " ".repeat(calculateIndent(firstDifference, firstSubtrahend)), firstSubtrahend,
                " ".repeat(calculateIndent(dividend, firstDifference)), "-".repeat(calculateHyphen(quotient, divisor))));

        output.append(String.format(" %s%s%s|%d\n", " ".repeat(calculateIndent(firstDifference, firstSubtrahend)),
                "-".repeat(getLengthOfNumber(firstSubtrahend)), " ".repeat(calculateIndent(dividend, firstDifference)), result.quotient()));

        formatDivisionSteps(result, output, indent);

        return output.toString();
    }

    private static int calculateHyphen(int quotient, int divisor) {
        return Math.max(getLengthOfNumber(quotient), getLengthOfNumber(divisor));
    }

    private static void formatDivisionSteps(Result result, StringBuilder output, int indent) {

        for (int i = 1; i < result.divisionSteps().size(); i++) {

            int difference = result.divisionSteps().get(i).difference();
            int subtrahend = result.divisionSteps().get(i).subtrahend();
            int remainderAfterEachStep = result.divisionSteps().get(i).remainderAfterEachStep();
            int quotientDigit = result.divisionSteps().get(i).quotientDigit();

            if (subtrahend == 0 && quotientDigit == 0) {
                indent = indent + 1;
            }

            if (difference != 0 && subtrahend != 0) {
                output.append(String.format("%s_%d\n", " ".repeat(indent - 1), difference));
                output.append(String.format("%s%d\n", " ".repeat(calculateSpecialIndent(indent, difference, subtrahend)), subtrahend));
                output.append(String.format("%s%s\n", " ".repeat(calculateSpecialIndent(indent, difference, subtrahend)),
                        "-".repeat(getLengthOfNumber(subtrahend))));
            }

            indent = indent + calculateIndent(subtrahend, remainderAfterEachStep);

            if (i + 1 == result.divisionSteps().size()) {

                if (subtrahend < difference) {
                    output.append(String.format("%s%d\n", " ".repeat(indent + calculateIndent(difference, subtrahend)), result.reminder()));
                } else {

                    output.append(String.format("%s%d\n", " ".repeat(indent), result.reminder()));
                }
            }
        }
    }

    private static int calculateSpecialIndent(int indent, int difference, int subtrahend) {
        if (getLengthOfNumber(subtrahend) < getLengthOfNumber(difference)) {
            indent = indent + calculateIndent(difference, subtrahend);
        }
        return indent;
    }

    private static int calculateIndent(int firstNumber, int secondNumber) {
        return getLengthOfNumber(firstNumber) - getLengthOfNumber(secondNumber);
    }

    private static int getLengthOfNumber(int number) {
        return String.valueOf(number).length();
    }


}
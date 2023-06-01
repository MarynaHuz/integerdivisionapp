package com.javajungle;

import com.javajungle.calculator.Calculator;
import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.formatter.FormatterFactory;
import com.javajungle.calculator.model.Result;

public class CalculatorApp {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Result result = calculator.divide(12543, -7);
        Formatter formatter = FormatterFactory.getInstance().get("US");
        String output = formatter.format(result);
        System.out.print(output);
    }
}

package com.javajungle;

import com.javajungle.calculator.Calculator;
import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.formatter.FormatterFactory;
import com.javajungle.calculator.model.Result;

public class CalculatorApp {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();  // main computing class
        Result result = calculator.divide(7894050, 4);
        Formatter formatter = FormatterFactory.getInstance().get("UA"); // Formatter is an interface
        String output = formatter.format(result); // formatted result
        System.out.print(output);

    }
}

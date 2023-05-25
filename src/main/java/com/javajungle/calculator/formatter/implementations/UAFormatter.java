package com.javajungle.calculator.formatter.implementations;


import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.model.Result;

public class UAFormatter implements Formatter {


    @Override
    public String format(Result result) {

        return String.format("%s", result);
    }
}

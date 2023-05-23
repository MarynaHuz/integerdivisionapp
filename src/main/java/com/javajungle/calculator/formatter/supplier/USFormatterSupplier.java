package com.javajungle.calculator.formatter.supplier;

import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.formatter.implementations.USFormatter;

public class USFormatterSupplier implements FormatterSupplier {
    @Override
    public String getName() {
        return "US";
    }

    @Override
    public Formatter get() {
        return new USFormatter();
    }
}

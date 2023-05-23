package com.javajungle.calculator.formatter.supplier;

import com.javajungle.calculator.formatter.Formatter;
import com.javajungle.calculator.formatter.implementations.UAFormatter;

public class UAFormatterSupplier implements FormatterSupplier {
    @Override
    public String getName() {
        return "UA";
    }

    @Override
    public Formatter get() {
        return new UAFormatter();
    }
}

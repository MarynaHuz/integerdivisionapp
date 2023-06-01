package com.javajungle.calculator.formatter.supplier;

import com.javajungle.calculator.formatter.Formatter;

import java.util.function.Supplier;

public interface FormatterSupplier extends Supplier<Formatter> {

    String getName();
}

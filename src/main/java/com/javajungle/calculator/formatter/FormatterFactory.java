package com.javajungle.calculator.formatter;


import com.javajungle.calculator.formatter.supplier.FormatterSupplier;
import com.javajungle.calculator.formatter.supplier.UAFormatterSupplier;
import com.javajungle.calculator.formatter.supplier.USFormatterSupplier;

import java.util.HashMap;
import java.util.Map;

public enum FormatterFactory {
    INSTANCE();
    private final Map<String, FormatterSupplier> suppliers;

    FormatterFactory() {
        suppliers = new HashMap<>();
        register(new UAFormatterSupplier());
        register(new USFormatterSupplier());
    }

    public static FormatterFactory getInstance() {
        return INSTANCE;
    }

    private void register(FormatterSupplier supplier) {
        suppliers.put(supplier.getName(), supplier);

    }

    public Formatter get(String name) {
        if (suppliers.containsKey(name)) {
            return suppliers.get(name).get();
        }
        throw new IllegalArgumentException("FormatterFactory with name '" + name + "' is not registered!");
    }


}

package ru.vsu.tools.converters;

import java.text.DecimalFormat;

public class DecimalConverter {

    private DecimalFormat df = new DecimalFormat("##,###,###.00");
    private static DecimalConverter INSTANCE;

    public static DecimalConverter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DecimalConverter();
        }
        return INSTANCE;
    }

    public String toDecimalFormat(double price) {
        return df.format(price);
    }

}

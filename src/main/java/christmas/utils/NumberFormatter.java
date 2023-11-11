package christmas.utils;

import java.text.NumberFormat;

public class NumberFormatter {
    public static String format(Integer input) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(input);
    }
}

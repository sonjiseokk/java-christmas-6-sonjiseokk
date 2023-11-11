package christmas.utils;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formatter {
    public static String numberFormat(Integer input) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(input);
    }
    public static String dateFormat(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M월 d일")
                .withLocale(Locale.KOREAN);
        return date.format(formatter);
    }
}

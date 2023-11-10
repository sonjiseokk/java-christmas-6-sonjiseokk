package christmas.service;

public class DateBasedDiscount {
    public static Integer calculateDiscount(int day) {
        int base = 1000;
        int baseDay = day - 1;
        return getDiscount(base, baseDay);
    }

    private static int getDiscount(final int base, final int baseDay) {
        return base + (baseDay * 100);
    }
}

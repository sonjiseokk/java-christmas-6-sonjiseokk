package christmas.service;

public class DateBasedDiscount {
    public static Integer calculateDiscount(int date) {
        int basePrice = 1000;
        int baseDate = date - 1;
        return getDiscount(basePrice, baseDate);
    }

    private static int getDiscount(final int basePrice, final int baseDate) {
        return basePrice + (baseDate * 100);
    }
}

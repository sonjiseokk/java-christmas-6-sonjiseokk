package christmas.constant;

public enum EventMonth {
    NOW(2023, 12);

    private final int year;
    private final int month;

    EventMonth(final int year, final int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }
}

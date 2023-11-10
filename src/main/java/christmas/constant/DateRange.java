package christmas.constant;

public enum DateRange {
    BEFORE_CHRISTMAS_EVENT(1,25),
    MONTH(1,31);

    private int start;
    private int end;

    DateRange(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

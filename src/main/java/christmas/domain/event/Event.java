package christmas.domain.event;

public enum Event {
    D_DAY_DISCOUNT("크리스마스 디데이 할인: ",1_000),
    WEEKDAY("평일 할인: ",2_023),
    WEEKEND("특별 할인: ",2_023),
    GIFT("증정 이벤트: ", 25_000);

    private final String keyword;
    private Integer discount;

    Event(final String keyword, final Integer discount) {
        this.keyword = keyword;
        this.discount = discount;
    }

    public String getKeyword() {
        return keyword;
    }

    public Integer getDiscount() {
        return discount;
    }
}

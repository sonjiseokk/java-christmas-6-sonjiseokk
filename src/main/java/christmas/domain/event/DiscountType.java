package christmas.domain.event;

public enum DiscountType {
    D_DAY_DISCOUNT("크리스마스 디데이 할인: "),
    WEEKDAY("평일 할인: "),
    WEEKEND("주말 할인: "),
    SPECIAL("특별 할인: "),
    GIFT("증정 이벤트: "),
    NO("없음");

    private final String keyword;

    DiscountType(final String keyword) {
        this.keyword = keyword;
    }


    public String getKeyword() {
        return keyword;
    }

}

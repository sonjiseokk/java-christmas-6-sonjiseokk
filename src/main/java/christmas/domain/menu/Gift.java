package christmas.domain.menu;


public enum Gift {
    CHAMPAGNE_GIFT("샴페인", 25_000),
    NO_GIFT("없음",0);
    private String name;
    private int price;

    Gift(final String name, final int price) {
        this.name = name;
        this.price = price;
    }
}
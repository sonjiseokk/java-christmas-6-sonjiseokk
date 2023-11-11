package christmas.domain.menu;


public enum Gift {
    CHAMPAGNE_GIFT("샴페인 1개", 25_000),
    NO_GIFT("없음",0);
    private final String name;
    private final int price;

    Gift(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

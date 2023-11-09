package christmas.domain.menu;

public enum DrinkMenu {
    ZERO_COKE("제로콜라", new Price(3_000)),
    RED_WINE("레드와인", new Price(60_000)),
    CHAMPAGNE("샴페인", new Price(25_000));

    private String name;
    private Price price;

    DrinkMenu(final String name, final Price price) {
        this.name = name;
        this.price = price;
    }
}

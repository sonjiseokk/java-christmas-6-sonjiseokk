package christmas.domain;

public enum DessertMenu {
    CHOCO_CAKE("초코케이크",new Price(15_000)),
    ICE_CREAM("아이스크림",new Price(5_000));
    private String name;
    private Price price;

    DessertMenu(final String name, final Price price) {
        this.name = name;
        this.price = price;
    }
}

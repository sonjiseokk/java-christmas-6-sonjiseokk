package christmas.domain;

import christmas.domain.menu.Price;

public enum EventBadge {
    STAR("별", new Price(5_000)),
    TREE("트리", new Price(10_000)),
    SANTA("산타", new Price(20_000));
    private String name;
    private Price price;

    EventBadge(final String name, final Price price) {
        this.name = name;
        this.price = price;
    }
}

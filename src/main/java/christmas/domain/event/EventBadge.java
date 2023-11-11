package christmas.domain.event;

public enum EventBadge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);
    private final String name;
    private final int price;

    EventBadge(final String name, final int price) {
        this.name = name;
        this.price = price;
    }
}

package christmas.domain.event;

public enum EventBadge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    NO("없음", 0);
    private final String name;
    private final int price;

    EventBadge(final String name, final int price) {
        this.name = name;
        this.price = price;
    }
    public static EventBadge findMyBadge(Integer totalDiscount) {
        if (totalDiscount >= STAR.price) {
            return STAR;
        }
        if (totalDiscount >= TREE.price) {
            return TREE;
        }
        if (totalDiscount >= SANTA.price) {
            return SANTA;
        }
        return NO;
    }
}

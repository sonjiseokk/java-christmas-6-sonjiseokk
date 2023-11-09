package christmas.domain.menu;

public enum AppetizerMenu {
    MUSHROOMSOUP("양송이스프", 6_000),
    TAPAS("타파스", 5_500),
    CAESARSALAD("시저샐러드", 8_000);
    private String name;
    private Integer price;

    AppetizerMenu(final String name, final Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}

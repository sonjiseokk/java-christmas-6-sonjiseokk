package christmas.domain.menu;

public enum MainMenu {
    /**
     * <메인>
     * 티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
     */
    TBONE_STAKE("티본스테이크", new Price(55_000)),
    BARBECUE_RIBS("바비큐립", new Price(54_000)),
    SEAFOOD_PASTA("해산물파스타", new Price(35_000)),
    CHRISTMAS_PASTA("크리스마스파스타", new Price(25_000)),
    ;
    private String name;
    private Price price;

    MainMenu(final String name, final Price price) {
        this.name = name;
        this.price = price;
    }
}

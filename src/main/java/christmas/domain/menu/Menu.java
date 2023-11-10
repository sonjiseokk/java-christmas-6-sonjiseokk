package christmas.domain.menu;

import static christmas.domain.menu.Category.*;

public enum Menu {

    MUSHROOMSOUP("양송이스프", new Price(6_000), APPETIZER_MENU),
    TAPAS("타파스", new Price(5_500), APPETIZER_MENU),
    CAESARSALAD("시저샐러드", new Price(8_000), APPETIZER_MENU),
    CHOCO_CAKE("초코케이크",new Price(15_000), DESSERT_MENU),
    ICE_CREAM("아이스크림",new Price(5_000), DESSERT_MENU),
    ZERO_COKE("제로콜라", new Price(3_000), DRINK_MENU),
    RED_WINE("레드와인", new Price(60_000), DRINK_MENU),
    CHAMPAGNE("샴페인", new Price(25_000), DRINK_MENU),
    TBONE_STAKE("티본스테이크", new Price(55_000), MAIN_MENU),
    BARBECUE_RIBS("바비큐립", new Price(54_000), MAIN_MENU),
    SEAFOOD_PASTA("해산물파스타", new Price(35_000), MAIN_MENU),
    CHRISTMAS_PASTA("크리스마스파스타", new Price(25_000), MAIN_MENU);
    private String name;
    private Price price;
    private Category category;

    Menu(final String name, final Price price, final Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

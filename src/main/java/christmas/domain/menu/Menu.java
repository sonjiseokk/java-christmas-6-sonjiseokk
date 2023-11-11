package christmas.domain.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static christmas.domain.menu.Category.*;

public enum Menu {

    MUSHROOMSOUP("양송이스프", 6_000, APPETIZER_MENU),
    TAPAS("타파스", 5_500, APPETIZER_MENU),
    CAESARSALAD("시저샐러드", 8_000, APPETIZER_MENU),
    CHOCO_CAKE("초코케이크",15_000, DESSERT_MENU),
    ICE_CREAM("아이스크림",5_000, DESSERT_MENU),
    ZERO_COKE("제로콜라", 3_000, DRINK_MENU),
    RED_WINE("레드와인", 60_000, DRINK_MENU),
    CHAMPAGNE("샴페인", 25_000, DRINK_MENU),
    TBONE_STAKE("티본스테이크", 55_000, MAIN_MENU),
    BARBECUE_RIBS("바비큐립", 54_000, MAIN_MENU),
    SEAFOOD_PASTA("해산물파스타", 35_000, MAIN_MENU),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MAIN_MENU);
    private String name;
    private int price;
    private Category category;

    Menu(final String name, final int price, final Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Menu getMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public static List<Menu> generateMenuList(Set<String> menuNames) {
        List<Menu> menuList = new ArrayList<>();
        for (String name : menuNames) {
            Menu menu = getMenuByName(name);
            if (menu != null) {
                menuList.add(menu);
            }
        }
        return menuList;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}

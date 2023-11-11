package christmas.domain.order;

import christmas.domain.menu.Gift;
import christmas.domain.menu.Menu;
import christmas.domain.validator.DateValidator;
import christmas.domain.validator.MenuValidator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.constant.EventMonth.DECEMBER_2023;

public class Order {
    private LocalDate date;
    private List<Menu> menus;

    public Order(final String date,final Map<String, Integer> inputMenus) {
        DateValidator.valid(date);
        MenuValidator.isMenuCountValid(inputMenus);

        List<Menu> menus = Menu.generateMenuList(inputMenus);
        MenuValidator.drinkValid(menus);

        int dateValue = Integer.parseInt(date);

        this.date = LocalDate.of(DECEMBER_2023.getYear(), DECEMBER_2023.getMonth(),dateValue);
        this.menus = menus;
    }
    public Map<String, Integer> getMenuCount() {
        Map<String, Integer> menuCount = new HashMap<>();
        for (Menu menu : this.menus) {
            String menuName = menu.getName();
            menuCount.put(menuName, menuCount.getOrDefault(menuName, 0) + 1);
        }
        return menuCount;
    }
    public int getTotalPrice() {
        return this.menus.stream()
                .mapToInt(menu -> menu.getPrice())
                .sum();
    }
    public Gift getGift(int totalPrice) {
        if (totalPrice > 120_000) {
            return Gift.CHAMPAGNE_GIFT;
        }
        return Gift.NO_GIFT;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}

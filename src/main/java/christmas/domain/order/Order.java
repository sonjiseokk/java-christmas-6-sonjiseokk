package christmas.domain.order;

import christmas.domain.menu.Gift;
import christmas.domain.menu.Menu;
import christmas.domain.validator.MenuValidator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.constant.EventMonth.NOW;

public class Order {
    private LocalDate date;
    private List<Menu> menus;

    public Order(final Integer date,final Map<String, Integer> menuValues) {
        MenuValidator.existMenuValid(menuValues);
        MenuValidator.countValid(menuValues);

        List<Menu> menus = Menu.convertToMenus(menuValues);
        MenuValidator.drinkValid(menus);

        this.date = LocalDate.of(NOW.getYear(), NOW.getMonth(),date);
        this.menus = menus;
    }
    public Map<String, Integer> countMenus() {
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

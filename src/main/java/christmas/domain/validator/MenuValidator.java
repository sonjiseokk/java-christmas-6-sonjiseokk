package christmas.domain.validator;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuValidator {
    public static void isMenuCountValid(Map<String, Integer> menus) throws IllegalArgumentException{
        if (isNotExistMenu(menus)) {
            throw new IllegalArgumentException("메뉴판에 없는 메뉴입니다.");
        }
        if (isNotValidCount(menus)) {
            throw new IllegalArgumentException("메뉴는 1개 이상, 20개 미만으로 주문해야합니다.");
        }
    }
    public static void priceAndDrinkValid(final List<Menu> menus) {
        if (isOnlyDrink(menus)) {
            throw new IllegalStateException("음료만 주문할 수 없습니다.");
        }
        if (totalPriceCheck(menus)) {
            throw new IllegalStateException("총 메뉴의 합이 10,000원 이상이여야 합니다.");
        }
    }

    private static boolean isNotValidCount(final Map<String, Integer> menus) {
        int count = 0;
        for (Integer value : menus.values()) {
            if ((value < 1) || (count > 20)) {
                return true;
            }
            count += 1;
        }
        return false;
    }

    private static boolean isNotExistMenu(final Map<String, Integer> menus) {
        Set<String> keySet = menus.keySet();
        for (String key : keySet) {
            if (Menu.getMenuByName(key) == null) {
                return true;
            }
        }
        return false;
    }
    private static boolean isOnlyDrink(List<Menu> menus) {
        long count = menus.stream().filter(menu -> menu.getCategory() == Category.DRINK_MENU)
                .count();
        return count == menus.size();
    }
    private static boolean totalPriceCheck(final List<Menu> menus) {
        return menus.stream().mapToInt(menu -> menu.getPrice()).sum() < 10_000;
    }


}

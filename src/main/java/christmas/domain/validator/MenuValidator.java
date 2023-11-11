package christmas.domain.validator;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuValidator {
    public static void isMenuCountValid(Map<String, Integer> menuValues) throws IllegalArgumentException{
        if (isNotExistMenu(menuValues)) {
            throw new IllegalArgumentException("메뉴판에 없는 메뉴입니다.");
        }
        if (isNotValidCount(menuValues)) {
            throw new IllegalArgumentException("메뉴는 1개 이상, 20개 미만으로 주문해야합니다.");
        }
    }
    public static void drinkValid(final List<Menu> menus) {
        if (isOnlyDrink(menus)) {
            throw new IllegalStateException("음료만 주문할 수 없습니다.");
        }
    }

    private static boolean isNotValidCount(final Map<String, Integer> menuValues) {
        int count = 0;
        for (Integer value : menuValues.values()) {
            if ((value < 1) || (count > 20)) {
                return true;
            }
            count += 1;
        }
        return false;
    }

    private static boolean isNotExistMenu(final Map<String, Integer> menuValues) {
        Set<String> keySet = menuValues.keySet();
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
}

package christmas.domain.validator;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuValidator {
    public static void existMenuValid(Map<String, Integer> menuValues) throws IllegalArgumentException {
        if (isNotExistMenu(menuValues)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    public static void countValid(Map<String, Integer> menuValues) throws IllegalArgumentException{
        if (isNotValidCount(menuValues)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    public static void drinkValid(final List<Menu> menus) {
        if (isOnlyDrink(menus)) {
            throw new IllegalStateException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    public static void totalPriceValid(final List<Menu> menus) {
        if (unsatisfyTotalPrice(menus)) {
            throw new IllegalStateException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
    private static boolean unsatisfyTotalPrice(List<Menu> menus) {
        int sum = menus.stream()
                .mapToInt(menu -> menu.getPrice())
                .sum();
        return sum < 10_000;
    }


}

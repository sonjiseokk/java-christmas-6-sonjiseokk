package christmas.domain.validator;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuValidator {
    public static void valid(Map<String, Integer> menus) throws IllegalArgumentException{
        /**
         * TODO: 있는 메뉴인지, 개수가 1이상인지, 음료만 있는건지, 최대 개수가 20개가 안넘는지 체크
         */
        if (isNotExistMenu(menus)) {
            throw new IllegalArgumentException("메뉴판에 없는 메뉴입니다.");
        }
        if (isNotValidCount(menus)) {
            throw new IllegalArgumentException("메뉴는 1개 이상, 20개 미만으로 주문해야합니다.");
        }
    }

    public static void onlyDrinkValid(List<Menu> menus) {
        long count = menus.stream().filter(menu -> menu.getCategory() == Category.DRINK_MENU)
                .count();

        if (count == menus.size()) {
            throw new IllegalArgumentException("음료만 주문할 수 없습니다.");
        }
    }

    private static boolean containOnlyDrink(final Map<String, Integer> menus) {
        return false;
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
}

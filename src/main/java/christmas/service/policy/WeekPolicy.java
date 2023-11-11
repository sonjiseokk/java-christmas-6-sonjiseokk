package christmas.service.policy;

import christmas.domain.event.Benefit;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;

import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static christmas.domain.event.DiscountType.*;
import static christmas.domain.menu.Category.DESSERT_MENU;
import static christmas.domain.menu.Category.MAIN_MENU;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

public class WeekPolicy implements Policy{
    private static final Set<DayOfWeek> WEEKEND_DAYS = EnumSet.of(FRIDAY, SATURDAY);
    @Override
    public Benefit apply(final Order order) {
        if (WEEKEND_DAYS.contains(order.getDate().getDayOfWeek())) {
            return getWeekendBenefit(order);
        }
        return getWeekdayBenefit(order);
    }

    private Benefit getWeekdayBenefit(final Order order) {
        int countWeekday = applyWeekday(order.getMenus());
        if (countWeekday > 0) {
            return new Benefit(WEEKDAY, countWeekday * 2023);
        }
        return new Benefit(NO, 0);
    }

    private Benefit getWeekendBenefit(final Order order) {
        int countWeekend = applyWeekend(order.getMenus());
        if (countWeekend > 0) {
            return new Benefit(WEEKEND, countWeekend * 2023);
        }
        return new Benefit(NO, 0);
    }

    private int applyWeekday(final List<Menu> menus) {
        List<Menu> collect = menus.stream().filter(menu -> menu.getCategory() == DESSERT_MENU)
                .toList();
        return collect.size();
    }

    private int applyWeekend(final List<Menu> menus) {
        List<Menu> collect = menus.stream().filter(menu -> menu.getCategory() == MAIN_MENU)
                .toList();
        return collect.size();
    }
}

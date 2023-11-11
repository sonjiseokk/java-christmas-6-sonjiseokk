package christmas.domain.order;

import christmas.domain.Week;
import christmas.domain.menu.Gift;
import christmas.domain.menu.Menu;
import christmas.domain.validator.DateValidator;
import christmas.domain.validator.MenuValidator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static christmas.constant.EventMonth.DECEMBER_2023;

public class Order {
    private static final Set<DayOfWeek> WEEKEND_DAYS = EnumSet.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
    private LocalDate date;
    private List<Menu> menus;

    public Order(final String date,final Map<String, Integer> inputMenus) {
        DateValidator.valid(date);
        MenuValidator.valid(inputMenus);

        List<Menu> menus = Menu.generateMenuList(inputMenus.keySet());
        MenuValidator.onlyDrinkValid(menus);

        int dateValue = Integer.parseInt(date);

        this.date = LocalDate.of(DECEMBER_2023.getYear(), DECEMBER_2023.getMonth(),dateValue);
        this.menus = menus;
    }
    public Week determineWeekType() {
        if (WEEKEND_DAYS.contains(this.date.getDayOfWeek())) {
            return Week.WEEKEND;
        }
        return Week.WEEKDAY;
    }
    public boolean canJoinEvent() {
        return this.getTotalPrice() >= 1_0000;
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

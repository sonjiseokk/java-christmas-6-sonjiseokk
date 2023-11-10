package christmas.domain;

import christmas.domain.menu.Gift;
import christmas.domain.menu.Menu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static christmas.domain.EventDate.DECEMBER_2023;

public class Order {
    private static final Set<DayOfWeek> WEEKEND_DAYS = EnumSet.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
    private LocalDate date;
    private List<Menu> menus;

    public Order(final int day,final List<Menu> menus) {
        // TODO: day valid
        this.date = LocalDate.of(DECEMBER_2023.getYear(), DECEMBER_2023.getMonth(),day);
        this.menus = menus;
    }
    public Week determineWeekType() {
        if (WEEKEND_DAYS.contains(this.date.getDayOfWeek())) {
            return Week.WEEKEND;
        }
        return Week.WEEKDAY;
    }
    public int getTotalPrice(List<Menu> menus) {
        return menus.stream()
                .mapToInt(menu -> menu.getPrice())
                .sum();
    }

    public Gift getGift(int totalPrice) {
        if (totalPrice > 120_000) {
            return Gift.CHAMPAGNE_GIFT;
        }
        return Gift.NO_GIFT;
    }

}

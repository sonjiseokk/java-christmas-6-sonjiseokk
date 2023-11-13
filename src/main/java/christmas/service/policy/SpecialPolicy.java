package christmas.service.policy;

import christmas.domain.event.Benefit;
import christmas.domain.order.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.domain.event.DiscountType.NO;
import static christmas.domain.event.DiscountType.SPECIAL;
import static java.time.DayOfWeek.SUNDAY;

public class SpecialPolicy implements Policy{
    private static final DayOfWeek specialDay = SUNDAY;

    @Override
    public Benefit apply(final Order order) {
        if (order.getTotalPrice() < 10000) {
            return new Benefit(NO, 0);
        }
        LocalDate today = order.getDate();
        if (today.getDayOfWeek() == specialDay || today.getDayOfMonth() == 25) {
            return new Benefit(SPECIAL, 1000);
        }
        return new Benefit(NO, 0);
    }
}

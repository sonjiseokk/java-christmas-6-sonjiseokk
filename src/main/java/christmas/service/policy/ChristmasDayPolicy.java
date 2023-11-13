package christmas.service.policy;

import christmas.domain.event.Benefit;
import christmas.domain.order.Order;

import static christmas.domain.event.DiscountType.D_DAY_DISCOUNT;
import static christmas.domain.event.DiscountType.NO;

public class ChristmasDayPolicy implements Policy{
    @Override
    public Benefit apply(Order order) {
        if (order.getTotalPrice() < 10000) {
            return new Benefit(NO, 0);
        }

        int dayOfMonth = order.getDate().getDayOfMonth();

        if (dayOfMonth > 25) {
            return new Benefit(NO, 0);
        }
        int base = 1000;
        int baseDate = dayOfMonth -1;
        return new Benefit(D_DAY_DISCOUNT,getDiscount(base, baseDate));
    }
    private static int getDiscount(final int basePrice, final int baseDate) {
        return basePrice + (baseDate * 100);
    }
}

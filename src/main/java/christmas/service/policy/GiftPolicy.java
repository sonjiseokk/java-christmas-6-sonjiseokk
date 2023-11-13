package christmas.service.policy;

import christmas.domain.event.Benefit;
import christmas.domain.menu.Gift;
import christmas.domain.order.Order;

import static christmas.domain.event.DiscountType.GIFT;
import static christmas.domain.event.DiscountType.NO;
import static christmas.domain.menu.Gift.CHAMPAGNE_GIFT;

public class GiftPolicy implements Policy{

    @Override
    public Benefit apply(final Order order) {
        if (order.getTotalPrice() < 10000) {
            return new Benefit(NO, 0);
        }
        Gift orderGift = order.getGift(order.getTotalPrice());
        if (orderGift == CHAMPAGNE_GIFT) {
            return new Benefit(GIFT, CHAMPAGNE_GIFT.getPrice());
        }
        return new Benefit(NO, 0);
    }
}

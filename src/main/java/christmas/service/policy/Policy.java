package christmas.service.policy;

import christmas.domain.event.Benefit;
import christmas.domain.order.Order;

public interface Policy {
    Benefit apply(Order order);
}

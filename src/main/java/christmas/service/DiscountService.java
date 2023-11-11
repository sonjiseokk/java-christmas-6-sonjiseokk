package christmas.service;

import christmas.domain.event.Benefit;
import christmas.domain.event.DiscountType;
import christmas.domain.order.Order;
import christmas.service.policy.Policy;

import java.util.List;
import java.util.stream.Collectors;

public class DiscountService {
    private final List<Policy> policies;

    public DiscountService(final List<Policy> policies) {
        this.policies = policies;
    }

    public List<Benefit> discount(Order order) {
        List<Benefit> benefits = policies.stream()
                .map(policy -> policy.apply(order))
                .filter(benefit -> benefit.getDiscountType() != DiscountType.NO)
                .collect(Collectors.toList());
        if (benefits.isEmpty()) {
            benefits.add(new Benefit(DiscountType.NO, 0));
        }
        return benefits;
    }

    public Integer totalDiscount(List<Benefit> benefits) {
        return benefits.stream().mapToInt(benefit -> benefit.getDiscount())
                .sum();
    }

    public Integer totalDiscountNoGift(final List<Benefit> benefits) {
        return benefits.stream()
                .filter(benefit -> benefit.getDiscountType() != DiscountType.GIFT)
                .mapToInt(benefit -> benefit.getDiscount())
                .sum();
    }
}

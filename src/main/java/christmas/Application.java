package christmas;

import christmas.controller.EventController;
import christmas.service.DiscountService;
import christmas.service.policy.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Policy> policies = List.of(new ChristmasDayPolicy(),new GiftPolicy(),new SpecialPolicy(), new WeekPolicy());
        DiscountService discountService = new DiscountService(policies);
        EventController controller = new EventController(discountService);
        try {
            controller.play();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}

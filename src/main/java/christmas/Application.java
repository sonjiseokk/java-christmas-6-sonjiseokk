package christmas;

import christmas.config.PolicyManager;
import christmas.controller.EventController;
import christmas.service.DiscountService;
import christmas.service.policy.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Policy> policies = PolicyManager.getPolices();
        DiscountService discountService = new DiscountService(policies);
        EventController controller = new EventController(discountService);
        try {
            controller.play();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}

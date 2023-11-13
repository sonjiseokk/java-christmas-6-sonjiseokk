package christmas.config;

import christmas.service.policy.*;

import java.util.List;

public class PolicyManager {
    public static List<Policy> getPolices() {
        return List.of(
                new ChristmasDayPolicy(),
                new GiftPolicy(),
                new SpecialPolicy(),
                new WeekPolicy()
        );
    }
}

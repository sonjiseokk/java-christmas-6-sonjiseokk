package christmas.controller;

import christmas.domain.event.Benefit;
import christmas.domain.event.EventBadge;
import christmas.domain.order.Order;
import christmas.service.DiscountService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class EventController {
    private final DiscountService discountService;

    public EventController(final DiscountService discountService) {
        this.discountService = discountService;
    }

    public void play() {
        OutputView.printStart();
        String date = InputView.readDate();
        Map<String, Integer> menusMap = InputView.orderMenu();

        Order order = new Order(date, menusMap);
        orderOrientedPrint(order);

        List<Benefit> benefits = discountService.discount(order);
        Integer totalDiscount = discountService.totalDiscount(benefits);
        Integer realDiscount = discountService.totalDiscountNoGift(benefits);
        EventBadge myBadge = EventBadge.findMyBadge(totalDiscount);
        serviceOrientedPrint(benefits, totalDiscount, order, realDiscount, myBadge);
    }

    private static void orderOrientedPrint(final Order order) {
        OutputView.printEvent(order.getDate());
        OutputView.printMenu(order.getMenuCount());
        OutputView.printTotalPriceBeforeDiscount(order.getTotalPrice());
        OutputView.printGiveaway(order.getGift(order.getTotalPrice()));
    }
    private static void serviceOrientedPrint(final List<Benefit> benefits,
                                             final Integer totalDiscount, final Order order,
                                             final Integer realDiscount, final EventBadge myBadge) {
        OutputView.printBenefit(benefits);
        OutputView.printTotalPriceAfterDiscount(totalDiscount);
        OutputView.printPaymentPrice(order.getTotalPrice() - realDiscount);
        OutputView.printEventBadge(myBadge);
    }
}

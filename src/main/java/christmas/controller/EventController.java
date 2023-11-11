package christmas.controller;

import christmas.domain.order.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class EventController {
    public void play() {
        OutputView.printStart();
        String date = InputView.readDate();
        Map<String, Integer> menusMap = InputView.orderMenu();

        Order order = new Order(date, menusMap);
        orderOrientedPrint(order);

    }

    private static void orderOrientedPrint(final Order order) {
        OutputView.printEvent(order.getDate());
        OutputView.printMenu(order.getMenuCount());
        OutputView.printTotalPriceBeforeDiscount(order.getTotalPrice());
        OutputView.printGiveaway(order.getGift(order.getTotalPrice()));
    }
}

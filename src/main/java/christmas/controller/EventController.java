package christmas.controller;

import christmas.domain.order.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class EventController {
    public void play() {
        String date = InputView.readDate();
        Map<String, Integer> menusMap = InputView.orderMenu();

        Order order = new Order(date, menusMap);
        OutputView.printEvent(order.getDate());
        OutputView.printMenu(order.getMenus());
        OutputView.printTotalPriceBeforeDiscount(order.getTotalPrice());

    }
}

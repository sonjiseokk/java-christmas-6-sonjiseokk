package christmas.controller;

import christmas.domain.order.Order;
import christmas.view.InputView;

import java.util.Map;

public class EventController {
    public void play() {
        String date = InputView.readDate();
        Map<String, Integer> menusMap = InputView.orderMenu();

        Order order = new Order(date, menusMap);

    }
}

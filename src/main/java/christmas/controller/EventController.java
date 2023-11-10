package christmas.controller;

import christmas.view.InputView;

public class EventController {
    public void play() {
        String date = InputView.readDate();
        InputView.orderMenu();

    }
}

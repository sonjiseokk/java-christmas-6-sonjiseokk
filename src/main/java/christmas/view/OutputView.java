package christmas.view;

import christmas.domain.menu.Menu;
import christmas.utils.NumberFormatter;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

public class OutputView {
    private final NumberFormat formatter;
    public OutputView() {
        formatter = NumberFormat.getNumberInstance();
    }
    public static void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public static void printEvent(LocalDate date) {
        System.out.println(date.getMonth() + "월 " +
                date.getDayOfMonth() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }
    public static void printMenu(final List<Menu> menus) {
        System.out.println("<주문 메뉴>");
        for (Menu menu : menus) {
            System.out.println(menu.getName() + " " + Menu.countMenu(menus, menu) + "개");
        }
        System.out.println();
    }
    public static void printTotalPriceBeforeDiscount(final int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(NumberFormatter.format(totalPrice)+"원");
        System.out.println();
    }
    public static void printGiveaway() {
        System.out.println("<증정 메뉴>");
    }
    public static void printBenefit() {
        System.out.println("<혜택 내역>");
    }

    public static void printTotalPriceAfterDiscount() {
        System.out.println("<총혜택 금액>");
    }

    public static void printPaymentPrice() {
        System.out.println("<할인 후 예상 결제 금액>");
    }
    public static void printEventBadge() {
        System.out.println("<12월 이벤트 배지>");
    }
}

package christmas.view;

import christmas.domain.event.Benefit;
import christmas.domain.event.DiscountType;
import christmas.domain.event.EventBadge;
import christmas.domain.menu.Gift;
import christmas.utils.Formatter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public static void printEvent(LocalDate date) {
        String dateFormat = Formatter.dateFormat(date);
        System.out.println(dateFormat + "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        nextLine();
    }
    public static void printMenu(final Map<String, Integer> menuCount) {
        System.out.println("<주문 메뉴>");
        menuCount.forEach((menuName, count) -> System.out.println(menuName + " " + count + "개"));
        nextLine();
    }
    public static void printTotalPriceBeforeDiscount(final int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(Formatter.priceFormat(totalPrice)+"원");
        nextLine();
    }
    public static void printGiveaway(final Gift gift) {
        System.out.println("<증정 메뉴>");
        System.out.println(gift.getName());
        nextLine();
    }
    public static void printBenefit(final List<Benefit> benefits) {
        System.out.println("<혜택 내역>");
        for (Benefit benefit : benefits) {
            DiscountType type = benefit.getDiscountType();
            String number = Formatter.priceFormat(benefit.getDiscount());
            System.out.println(type.getKeyword() + "-"+number+"원");
        }
        nextLine();
    }

    public static void printTotalPriceAfterDiscount(final Integer totalDiscount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-"+Formatter.priceFormat(totalDiscount)+"원");
        nextLine();
    }

    public static void printPaymentPrice(final Integer price) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(Formatter.priceFormat(price) + "원");
        nextLine();
    }
    public static void printEventBadge(final EventBadge eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventBadge);
        nextLine();
    }

    private static void nextLine() {
        System.out.println();
    }
}

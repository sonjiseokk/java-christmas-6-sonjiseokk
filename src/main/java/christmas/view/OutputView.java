package christmas.view;

public class OutputView {
    public void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public void printEvent(int date) {
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
    public void printMenu() {
        System.out.println("<주문 메뉴>");
    }
    public void printTotalPriceBeforeDiscount() {
        System.out.println("<할인 전 총주문 금액>");
    }
    public void printGiveaway() {
        System.out.println("<증정 메뉴>");
    }
    public void printBenefit() {
        System.out.println("<혜택 내역>");
    }

    public void printTotalPriceAfterDiscount() {
        System.out.println("<총혜택 금액>");
    }

    public void printPaymentPrice() {
        System.out.println("<할인 후 예상 결제 금액>");
    }
    public void printEventBadge() {
        System.out.println("<12월 이벤트 배지>");
    }
}

package christmas.service.policy;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.event.Benefit;
import christmas.domain.menu.Gift;
import christmas.domain.order.Order;
import christmas.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static christmas.domain.event.DiscountType.GIFT;
import static christmas.domain.event.DiscountType.NO;
import static org.assertj.core.api.Assertions.assertThat;

class GiftPolicyTest {
    private static final Integer CAN_PARTICIPATE_DATE = 15;
    private static final String CAN_PARTICIPATE_MENUS = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
    private static final String CANT_PARTICIPATE_MENUS = "바비큐립-1,초코케이크-2,제로콜라-1";
    private static final String CANT_PARTICIPATE_MENUS_UNDER_THOUSAND = "타파스-1,제로콜라-1";
    @AfterEach
    void after() {
        Console.close();
    }
    @Test
    @DisplayName("샴페인이 증정된 경우")
    void 샴페인이_증정된_경우() throws Exception {
        //given
        Order order = getOrder(CAN_PARTICIPATE_DATE, CAN_PARTICIPATE_MENUS);
        //when
        GiftPolicy policy = new GiftPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscount()).isEqualTo(Gift.CHAMPAGNE_GIFT.getPrice());
        assertThat(benefit.getDiscountType()).isEqualTo(GIFT);

    }
    @Test
    @DisplayName("샴페인이 증정되지 않은 경우")
    void 샴페인이_증정되지_않은_경우() throws Exception {
        //given
        Order order = getOrder(CAN_PARTICIPATE_DATE, CANT_PARTICIPATE_MENUS);
        //when
        GiftPolicy policy = new GiftPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscount()).isEqualTo(Gift.NO_GIFT.getPrice());
        assertThat(benefit.getDiscountType()).isEqualTo(NO);
    }
    @Test
    @DisplayName("만원 미만으로 주문한 경우")
    void 만원_미만으로_주문한_경우() throws Exception {
        //given
        Order order = getOrder(CAN_PARTICIPATE_DATE, CANT_PARTICIPATE_MENUS_UNDER_THOUSAND);
        //when
        GiftPolicy policy = new GiftPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscount()).isEqualTo(Gift.NO_GIFT.getPrice());
        assertThat(benefit.getDiscountType()).isEqualTo(NO);
    }

    private static Order getOrder(Integer userDate, String userInput) {
        Map<String, Integer> orderMenu = getOrderMenu(userInput);
        return new Order(userDate, orderMenu);
    }

    private static Map<String, Integer> getOrderMenu(final String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //when
        return InputView.orderMenu();
    }
}
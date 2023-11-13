package christmas.service.policy;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.event.Benefit;
import christmas.domain.order.Order;
import christmas.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static christmas.domain.event.DiscountType.*;
import static org.assertj.core.api.Assertions.assertThat;

class WeekPolicyTest {
    private static final Integer WEEKDAY_PARTICIPATE_DATE = 7;
    private static final Integer WEEKEND_PARTICIPATE_DATE = 1;
    private static final String CAN_PARTICIPATE_MENUS = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
    private static final String CANT_PARTICIPATE_MENUS_UNDER_THOUSAND = "타파스-1,제로콜라-1";
    @AfterEach
    void after() {
        Console.close();
    }
    @Test
    @DisplayName("평일 할인이 적용되는 경우")
    void 평일_할인이_적용되는_경우() throws Exception {
        //given
        Order order = getOrder(WEEKDAY_PARTICIPATE_DATE, CAN_PARTICIPATE_MENUS);
        //when
        WeekPolicy policy = new WeekPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscountType()).isEqualTo(WEEKDAY);
        assertThat(benefit.getDiscount()).isEqualTo(4046);
    }
    @Test
    @DisplayName("주말 할인이 적용되는 경우")
    void 주말_할인이_적용되는_경우() throws Exception {
        //given
        Order order = getOrder(WEEKEND_PARTICIPATE_DATE, CAN_PARTICIPATE_MENUS);
        //when
        WeekPolicy policy = new WeekPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscountType()).isEqualTo(WEEKEND);
        assertThat(benefit.getDiscount()).isEqualTo(4046);
    }
    @Test
    @DisplayName("만원 미만으로 주문한 경우")
    void 만원_미만으로_주문한_경우() throws Exception {
        //given
        Order order = getOrder(WEEKEND_PARTICIPATE_DATE, CANT_PARTICIPATE_MENUS_UNDER_THOUSAND);
        //when
        WeekPolicy policy = new WeekPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscount()).isEqualTo(0);
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
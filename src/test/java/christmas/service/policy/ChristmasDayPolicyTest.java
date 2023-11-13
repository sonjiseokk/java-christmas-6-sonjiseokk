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

import static christmas.domain.event.DiscountType.D_DAY_DISCOUNT;
import static christmas.domain.event.DiscountType.NO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChristmasDayPolicyTest {
    private static final Integer CANT_DISCOUNT_D_DAY_CHRISTAMAS_EVENT = 26;
    private static final Integer CAN_DISCOUNT_D_DAY_CHRISTAMAS_EVENT = 15;
    @AfterEach
    void after() {
        Console.close();
    }
    @Test
    @DisplayName("크리스마스 할인 적용이 되는 경우")
    void 크리스마스_할인_적용이_되는_경우() throws Exception {
        //given
        Order order = getOrder(CAN_DISCOUNT_D_DAY_CHRISTAMAS_EVENT);
        //when
        ChristmasDayPolicy policy = new ChristmasDayPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscountType()).isEqualTo(D_DAY_DISCOUNT);
        assertThat(benefit.getDiscount()).isEqualTo((CAN_DISCOUNT_D_DAY_CHRISTAMAS_EVENT-1) * 100 + 1000);
    }
    @Test
    @DisplayName("크리스마스 할인 적용이 안되는 경우")
    void 크리스마스_할인_적용이_안되는_경우() throws Exception {
        //given
        Order order = getOrder(CANT_DISCOUNT_D_DAY_CHRISTAMAS_EVENT);
        //when
        ChristmasDayPolicy policy = new ChristmasDayPolicy();
        Benefit benefit = policy.apply(order);
        //then
        assertThat(benefit.getDiscountType()).isEqualTo(NO);
        assertThat(benefit.getDiscount()).isEqualTo(0);
    }

    private static Order getOrder(Integer userDate) {
        Integer date = userDate;
        Map<String, Integer> orderMenu = getOrderMenu();
        return new Order(date, orderMenu);
    }

    private static Map<String, Integer> getOrderMenu() {
        String userInput = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //when
        return InputView.orderMenu();
    }
}
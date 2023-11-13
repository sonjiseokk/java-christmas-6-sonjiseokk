package christmas.service;

import christmas.domain.event.Benefit;
import christmas.domain.order.Order;
import christmas.service.policy.ChristmasDayPolicy;
import christmas.service.policy.SpecialPolicy;
import christmas.service.policy.WeekPolicy;
import christmas.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountServiceTest {
    private final Integer SPECIAL_AND_WEEKDAY_DATE = 3;
    private final Integer SPECIAL_AND_WEEKEND_DATE = 25;
    private final Integer WEEKEND_AND_CHRISTMAS_DATE = 24;

    @Test
    @DisplayName("평일 할인과 특별 할인이 중복된 경우")
    void 평일_할인과_특별_할인이_중복된_경우() throws Exception {
        //given
        Order order = getOrder(SPECIAL_AND_WEEKDAY_DATE, "티본스테이크-1,바비큐립-1,초코케이크-1,제로콜라-1");
        //when
        DiscountService discountService = new DiscountService(
                List.of(new WeekPolicy(), new SpecialPolicy())
        );
        List<Benefit> benefits = discountService.discount(order);
        //then

        assertThat(discountService.totalDiscount(benefits)).isEqualTo(3023);
    }
    @Test
    @DisplayName("주말 할인과 특별 할인이 중복된 경우")
    void 주말_할인과_특별_할인이_중복된_경우() throws Exception {
        //given
        Order order = getOrder(SPECIAL_AND_WEEKEND_DATE, "티본스테이크-1,바비큐립-1,초코케이크-1,제로콜라-1");
        //when
        DiscountService discountService = new DiscountService(
                List.of(new WeekPolicy(), new SpecialPolicy())
        );
        List<Benefit> benefits = discountService.discount(order);
        //then

        assertThat(discountService.totalDiscount(benefits)).isEqualTo(5046);
    }
    @Test
    @DisplayName("크리스마스 할인과 평일 할인이 중복된 경우")
    void 크리스마스_할인과_평일_할인이_중복된_경우() throws Exception {
        //given
        Order order = getOrder(WEEKEND_AND_CHRISTMAS_DATE, "티본스테이크-1,바비큐립-1,초코케이크-1,제로콜라-1");
        //when
        DiscountService discountService = new DiscountService(
                List.of(new WeekPolicy(), new ChristmasDayPolicy())
        );
        List<Benefit> benefits = discountService.discount(order);
        //then

        assertThat(discountService.totalDiscount(benefits)).isEqualTo(3300 + 2023);
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
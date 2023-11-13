package christmas.domain.validator;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.menu.Menu;
import christmas.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MenuValidatorTest {
    @AfterEach
    void after() {
        closeConsole();
    }
    @Test
    @DisplayName("메뉴 목록에 없는 메뉴를 입력한 경우")
    void 메뉴_목록에_없는_메뉴를_입력한_경우() throws Exception {
        //given
        String userInput = "타파스-1,펩시제로망고-1";
        Map<String, Integer> orderMenu = getOrderMenu(userInput);
        //then
        assertThatThrownBy(() -> MenuValidator.existMenuValid(orderMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("메뉴 개수가 1미만인 경우")
    void 메뉴_개수가_1미만인_경우() throws Exception {
        //given
        String userInput = "타파스-0,제로콜라-1";
        Map<String, Integer> orderMenu = getOrderMenu(userInput);
        //then
        assertThatThrownBy(() -> MenuValidator.countValid(orderMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("음료만 주문한 경우")
    void 음료만_주문한_경우() throws Exception {
        //given
        String userInput = "펩시제로망고-1";
        Map<String, Integer> orderMenu = getOrderMenu(userInput);
        List<Menu> menus = Menu.convertToMenus(orderMenu);
        //then
        assertThatThrownBy(() -> MenuValidator.drinkValid(menus))
                .isInstanceOf(IllegalStateException.class);
    }
    @Test
    @DisplayName("최소 주문금액을 못채운 경우")
    void 최소_주문금액을_못채운_경우() throws Exception {
        //given
        String userInput = "양송이스프-1,제로콜라-1";
        Map<String, Integer> orderMenu = getOrderMenu(userInput);
        List<Menu> menus = Menu.convertToMenus(orderMenu);
        //then
        assertThatThrownBy(() -> MenuValidator.totalPriceValid(menus))
                .isInstanceOf(IllegalStateException.class);
    }

    private static Map<String, Integer> getOrderMenu(final String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        return InputView.orderMenu();
    }
    private static void closeConsole() {
        Console.close();
    }
}
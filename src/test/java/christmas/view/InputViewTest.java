package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @AfterEach
    void after() {
        closeConsole();
    }
    @Test
    @DisplayName("날짜를 정확하게 입력한 경우")
    void 정상값을_입력한_경우() throws Exception {
        // given
        String userInput = "3";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        Integer date = InputView.readDate();

        // then
        assertThat(date).isEqualTo(3);
    }
    @Test
    @DisplayName("날짜의 범위가 잘못된 경우")
    void 날짜의_범위가_잘못된_경우() throws Exception {
        String[] userInputs = {"0", "32","-1"};

        for (String userInput : userInputs) {
            InputStream in = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(in);

            assertThatThrownBy(InputView::readDate)
                    .isInstanceOf(IllegalArgumentException.class);
            closeConsole();
        }
    }

    @Test
    @DisplayName("날짜의 타입이 숫자가 아닌 경우")
    void 날짜의_타입이_숫자가_아닌_경우() throws Exception {
        // given
        String userInput = "aa";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // then
        assertThatThrownBy(InputView::readDate)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("주문 메뉴가 정확하게 작성된 경우")
    void 주문_메뉴가_정확하게_작성된_경우() throws Exception {
        //given
        String userInput = "타파스-1,제로콜라-1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //when
        Map<String, Integer> orderMenu = InputView.orderMenu();
        //then
        assertThat(orderMenu.get("타파스")).isEqualTo(1);
        assertThat(orderMenu.get("제로콜라")).isEqualTo(1);
    }
    @Test
    @DisplayName("주문 수량이 숫자가 아닌 경우")
    void 주문_수량이_숫자가_아닌_경우() throws Exception {
        //given
        String userInput = "타파스-1,제로콜라-a";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // then
        assertThatThrownBy(InputView::orderMenu)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("주문 메뉴에 공백이 들어온 경우")
    void 주문_메뉴에_공백이_들어온_경우() throws Exception {
        //given
        String userInput = "타파스-1, ,,,제로콜라-1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // then
        assertThatThrownBy(InputView::orderMenu)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("메뉴 사이의 하이픈이 중복된 경우")
    void 메뉴_사이의_하이픈이_중복된_경우() throws Exception {
        //given
        String userInput = "타파스--1,제로콜라-1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // then
        assertThatThrownBy(InputView::orderMenu)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("주문 수량이 생략된 경우")
    void 주문_수량이_생략된_경우() throws Exception {
        //given
        String userInput = "타파스-,제로콜라-1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // then
        assertThatThrownBy(InputView::orderMenu)
                .isInstanceOf(IllegalArgumentException.class);
    }
    private static void closeConsole() {
        Console.close();
    }
}
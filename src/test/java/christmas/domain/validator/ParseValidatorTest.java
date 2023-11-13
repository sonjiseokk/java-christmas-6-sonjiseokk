package christmas.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParseValidatorTest {
    @Test
    @DisplayName("콤마가 정상적으로 작성된 경우")
    void 콤마가_정상적으로_작성된_경우() throws Exception {
        //given
        String userInput = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        String[] parts = userInput.split(",");
        //then
        assertThatCode(() -> ParseValidator.separatorValid(parts))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("콤마가 중복되어 작성된 경우")
    void 콤마가_중복되어_작성된_경우() throws Exception {
        //given
        String userInput = "티본스테이크-1,,,바비큐립-1,초코케이크-2,제로콜라-1";
        String[] parts = userInput.split(",");
        //then
        assertThatThrownBy(() -> ParseValidator.separatorValid(parts))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("값이 입력되지 않은 경우")
    void 값이_입력되지_않은_경우() throws Exception {
        //given
        String userInput = "티본스테이크-1, ,  ";
        String[] parts = userInput.split(",");
        //then
        assertThatThrownBy(() -> ParseValidator.separatorValid(parts))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("하이픈이 중복 입력된 경우")
    void 하이픈이_중복_입력된_경우() throws Exception {
        //given
        String userInput = "티본스테이크-------1,바비큐립-1";
        String[] parts = userInput.split(",");
        //then
        assertThatThrownBy(() -> ParseValidator.separatorValid(parts))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("하이픈이 입력되지 않은 경우")
    void 하이픈이_입력되지_않은_경우() throws Exception {
        //given
        String userInput = "티본스테이크1,바비큐립-1";
        String[] parts = userInput.split(",");
        //then
        assertThatThrownBy(() -> ParseValidator.separatorValid(parts))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
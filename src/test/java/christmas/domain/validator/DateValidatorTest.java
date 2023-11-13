package christmas.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DateValidatorTest {
    @Test
    @DisplayName("날짜가 정상적으로 입력된 경우")
    void 날짜가_정상적으로_입력된_경우() throws Exception {
        //given
        String date = "3";
        //then
        assertThatCode(() -> DateValidator.valid(date))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("날짜에 문자가 입력된 경우")
    void 날짜에_문자가_입력된_경우() throws Exception {
        //given
        String date = "aa";
        //then
        assertThatThrownBy(() -> DateValidator.valid(date))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("날짜가 공백으로 입력된 경우")
    void 날짜가_공백으로_입력된_경우() throws Exception {
        //given
        String date = " ";
        //then
        assertThatThrownBy(() -> DateValidator.valid(date))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("날짜의 범위가 해당 달의 기준일에서 벗어나는 경우")
    void 날짜의_범위가_해당_달의_기준일에서_벗어나는_경우() throws Exception {
        //given
        String date1 = "0";
        String date2 = "32";

        //then
        assertThatThrownBy(() -> DateValidator.valid(date1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> DateValidator.valid(date2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
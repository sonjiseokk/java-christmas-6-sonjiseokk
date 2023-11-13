package christmas.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static christmas.constant.EventMonth.NOW;
import static org.assertj.core.api.Assertions.assertThat;

class FormatterTest {
    @Test
    @DisplayName("priceFormat 테스트")
    void priceFormat_테스트() throws Exception {
        //given
        Integer num = 100000000;
        //when
        String priceFormat = Formatter.priceFormat(num);
        //then
        assertThat(priceFormat).isEqualTo("100,000,000");
    }
    @Test
    @DisplayName("dateFormat 테스트")
    void dateFormat_테스트() throws Exception {
        //given
        LocalDate date = LocalDate.of(NOW.getYear(), NOW.getMonth(), 25);
        //when
        String dateFormat = Formatter.dateFormat(date);
        //then
        assertThat(dateFormat).isEqualTo("12월 25일");
    }

}
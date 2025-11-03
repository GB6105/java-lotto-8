package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @DisplayName("문자를 정수로 변환한다.")
    @Test
    public void priceParserTest() {
        //given
        String priceInput = "15000";
        int priceResult = 15000;

        //when
        Parser parser = new Parser();
        int price = parser.number(priceInput);

        //then
        assertThat(price).isEqualTo(priceResult);
    }

    @DisplayName("문자를 정수 List로 변환한다.")
    @Test
    public void targetNumberParserTest() {
        //given
        String targetNumberInput = "1,2,3,4,5,6";
        List<Integer> targetNumberResult = List.of(1, 2, 3, 4, 5, 6);

        //when
        Parser parser = new Parser();
        List<Integer> targetNumber = parser.numbers(targetNumberInput);

        //then
        assertThat(targetNumber).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}

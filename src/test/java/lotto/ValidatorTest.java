package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {
    @DisplayName("숫자 범위가 1 ~ 45 를 넘어갈 수 없다.")
    @ParameterizedTest
    @CsvSource({
            "0",
            "46",
            "10000",
            "-1"
    })
    public void rangeTest(int invalidNumber) {

        assertThatThrownBy(() -> Validator.validateNumberRange(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 범위는 1 ~ 45 이어야 합니다.");
    }

    @DisplayName("금액은 최소 1000원 부터 가능하다")
    @ParameterizedTest
    @CsvSource({
            "0",
            "100"
    })
    public void priceRangeTest(int invalidNumber) {
        assertThatThrownBy(() -> Validator.validatePriceRange(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 최소 1000원입니다.");
    }

    @DisplayName("금액 단위가 1000으로 나누어지지 않으면 오류를 발생")
    @ParameterizedTest
    @CsvSource({
            "1001",
            "1100",
            "1010",
            "1999",
            "109999"
    })
    public void unitTest(int invalidNumber) {
        assertThatThrownBy(() -> Validator.validatePriceUnit(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액 단위는 1000원 단위입니다.");
    }
}

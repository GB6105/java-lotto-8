package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusNumberTest {
    private final List<Integer> LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호는 1 ~ 45 범위를 벗어날 수 없다.")
    @ParameterizedTest
    @CsvSource({
            "0",
            "46",
            "-10",
            "100"
    })
    void bonusNumberRangeTest(int invalidNumber) {
        // when & then
        assertThatThrownBy(() -> BonusNumber.from(invalidNumber, LOTTO_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 범위는 1 ~ 45 이어야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

    // 유효한 당첨 번호 (기본값)
    private final List<Integer> VALID_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("유효한 당첨 번호와 보너스 번호로 객체가 성공적으로 생성되어야 한다.")
    @Test
    void createWinningNumbers_test() {
        // given
        int validBonusNumber = 7;

        // when
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS, validBonusNumber);

        // then
        assertThat(winningNumbers).isNotNull();
    }


    @DisplayName("당첨 번호 개수가 6개가 아니면 예외가 발생해야 한다.")
    @Test
    void winningNumbersSizeTest() {
        // given: 5개 번호
        List<Integer> invalidSizeNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(invalidSizeNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생해야 한다.")
    @Test
    void validateDuplicateWinningNumbersTest() {
        // given
        List<Integer> duplicateNumbers = List.of(1, 1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(duplicateNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 중복 될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "1",
            "6"
    })
    void validateBonusDuplicate(int duplicateBonus) {
        // when & then
        assertThatThrownBy(() -> new WinningNumbers(VALID_WINNING_NUMBERS, duplicateBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}
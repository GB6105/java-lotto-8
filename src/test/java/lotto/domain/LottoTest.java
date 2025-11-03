package lotto.domain;

import java.util.Arrays;
import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호와 당첨 번호를 비교하여 Rank를 반환한다.")
    @Test
    void lotto_match_test(){
        //given
        List<Integer> test = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(test);
        int bonusNumber = 10;

        //when
        WinningNumbers winningNumbers = new WinningNumbers(test,bonusNumber);
        Rank rankResult = lotto.match(winningNumbers);
        //then
        assertThat(rankResult).isEqualTo(Rank.FIRST);
    }
}

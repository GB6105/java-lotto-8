package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 45;

    private final int bonusNumber;

    private BonusNumber(int number, List<Integer> lotto) {
        validateRange(number);
        validateDuplicate(number, lotto);
        this.bonusNumber = number;
    }

    public static BonusNumber from(int number, List<Integer> lotto) {
        return new BonusNumber(number, lotto);
    }

    private void validateRange(int number) {
        if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1 ~ 45 이어야 합니다.");
        }
    }

    private void validateDuplicate(int number, List<Integer> lotto){
        if(checkDuplicate(number, lotto)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private boolean checkDuplicate(int number, List<Integer> lotto) {
        return lotto.stream().anyMatch(n -> n == number);
    }
}

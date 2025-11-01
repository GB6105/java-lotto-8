package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.constant.ErrorMessage;

public class WinningNumbers {
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 45;

    //당첨 번호와 보너스 번호를 관리
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> sortNumbers = new ArrayList<>(winningNumbers);
        Collections.sort(sortNumbers);

        // 검증
        validateSize(sortNumbers);
        validateDuplicate(sortNumbers);
        validateRange(bonusNumber);
        validateBonusDuplicate(bonusNumber,sortNumbers);

        this.winningNumbers = sortNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long originCount = numbers.size();

        long distinctNumbers = numbers.stream().distinct().count();
        if (originCount != distinctNumbers) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복 될 수 없습니다.");
        }
    }

    private void validateRange(int number) {
        if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE);
        }
    }

    private void validateBonusDuplicate(int number, List<Integer> lotto){
        if(checkDuplicate(number, lotto)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private boolean checkDuplicate(int number, List<Integer> lotto) {
        return lotto.stream().anyMatch(n -> n == number);
    }

    public boolean containsWinningNumber(int number) {
        return winningNumbers.contains(number);
    }

    public boolean containsBonusNumber(int number) {
        return bonusNumber == number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return bonusNumber == that.bonusNumber &&
                Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }

}

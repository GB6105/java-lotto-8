package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;

public class WinningNumbers {
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 45;
    private static final int NUMBER_SIZE = 6;

    //당첨 번호와 보너스 번호를 관리
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        // 검증
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers);
        validateRange(bonusNumber);
        validateBonusDuplicate(bonusNumber, winningNumbers);

        this.winningNumbers = winningNumbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long originCount = numbers.size();

        long distinctNumbers = numbers.stream().distinct().count();
        if (originCount != distinctNumbers) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusDuplicate(int number, List<Integer> lotto) {
        if (checkDuplicate(number, lotto)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
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

}

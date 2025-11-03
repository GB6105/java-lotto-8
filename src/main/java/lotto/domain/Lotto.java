package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
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

    public Rank match(WinningNumbers winningNumbers) {
        int matchCount = countMatchingNumbers(winningNumbers);
        boolean hasBonus = checkBonus(winningNumbers);
        return Rank.of(matchCount, hasBonus);
    }

    public int countMatchingNumbers(WinningNumbers winningNumbers) {
        long matchCount = this.numbers.stream()
                .filter(winningNumbers::containsWinningNumber)
                .count();
        return (int) matchCount;
    }

    private boolean checkBonus(WinningNumbers winningNumbers) {
        boolean matchBonus = this.numbers.stream()
                .anyMatch(winningNumbers::containsBonusNumber);
        return matchBonus;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
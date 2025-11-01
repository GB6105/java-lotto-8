package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers); // 테스트 코드를 위한 깊은 복사
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        long originCount = numbers.size();

        long distinctNumbers = numbers.stream().distinct().count();
        if (originCount != distinctNumbers) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복 될 수 없습니다.");
        }
    }

    public Rank match(WinningNumbers winningNumbers){
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
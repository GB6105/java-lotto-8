package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Parser {
    private static final int PRICE_UNIT = 1000;

    // 입력 받은 문자를 정수로 반환
    public int number(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE);
        }
    }

    // 입력 받은 문자를 정수 List로 반환
    public List<Integer> numbers(String number) {
        try {
            return Arrays.stream(number.split(","))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE);
        }
    }

}

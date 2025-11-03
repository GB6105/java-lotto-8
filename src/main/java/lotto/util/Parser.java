package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public final class Parser {
    // 입력 받은 문자를 정수로 반환
    public static int number(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE.getMessage());
        }
    }

    // 입력 받은 문자를 정수 List로 반환
    public static List<Integer> numbers(String number) {
        try {
            return Arrays.stream(number.split(","))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE.getMessage());
        }
    }

}

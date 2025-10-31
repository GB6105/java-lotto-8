package lotto.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final int PRICE_UNIT = 1000;

    // 입력 받은 금액을 정수로 반환
    public int price(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 입력 받은 당첨번호를 정수 List로 반환
    public List<Integer> targetNumber(String number) {
        try {
            return Arrays.stream(number.split(","))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    // 입력 받은 보너스 번호를 정수로 반환
    public int bonusNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseAmount(int price){
        return price / PRICE_UNIT;
    }
}

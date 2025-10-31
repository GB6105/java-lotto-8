package lotto.util;

import java.util.List;
import lotto.constant.ErrorMessage;

public final class Validator {
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 45;
    private static final int PRICE_RANGE_MIN = 1000;
    private static final int PRICE_UNIT = 1000;

    public static void validateNumberRange(int number) {
        if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE);
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validatePriceRange(int price) {
        if (price < PRICE_RANGE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MINIMUM);
        }
    }

    public static void validatePriceUnit(int price) {
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_UNIT);
        }
    }

}

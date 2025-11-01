package lotto.constant;

public final class ErrorMessage {
    public static final String NUMBER_RANGE = "[ERROR] 숫자의 범위는 1 ~ 45 이어야 합니다.";
    public static final String NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String NUMBER_TYPE = "[ERROR] 금액은 정수만 가능 합니다.";
    public static final String PRICE_MINIMUM = "[ERROR] 금액은 최소 1000원입니다.";
    public static final String PRICE_UNIT = "[ERROR] 금액 단위는 1000원 단위입니다.";

    private ErrorMessage() {}
}

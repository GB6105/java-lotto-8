package lotto.constant;

public enum ErrorMessage {
    NUMBER_RANGE("[ERROR] 숫자의 범위는 1 ~ 45 이어야 합니다."),
    NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBER_TYPE("[ERROR] 금액은 정수만 가능 합니다."),
    PRICE_RANGE("[ERROR] 금액은 최소 1000원 최대 100,000원 입니다."),
    PRICE_UNIT("[ERROR] 금액 단위는 1000원 단위입니다."),
    NUMBER_DUPLICATE("[ERROR] 숫자는 중복 될 수 없습니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

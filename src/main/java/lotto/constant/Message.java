package lotto.constant;

public enum Message {
    REQUIRE_PRICE("구입 금액을 입력해주세요"),
    REQUIRE_LOTTO("당첨 번호를 입력해주세요"),
    REQUIRE_BONUS_NUMBER("보너스 번호를 입력해주세요"),
    PURCHASE_MESSAGE("%d개를 구매했습니다."),
    RESULT_MESSAGE("당첨 통계"),
    MATCH_RESULT("%d개 일치 (%s원) - %d개"),
    MATCH_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_RESULT("총 수익률은 %.1f%%입니다.");

    private final String message;
    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

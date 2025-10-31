package lotto.view;

import lotto.constant.Message;

public class OutputView {

    public void printRequirePriceMessage() {
        System.out.println(Message.REQUIRE_PRICE.getMessage());
    }

    public void printRequireTargetNumberMessage() {
        System.out.println(Message.REQUIRE_LOTTO.getMessage());
    }

    public void printRequireBonusNumberMessage() {
        System.out.println(Message.REQUIRE_BONUS_NUMBER.getMessage());
    }

    public void printResult(){
        System.out.println(Message.RESULT_MESSAGE.getMessage());
        System.out.println("---");
    }

    public void printMatchResult(int matchCount, int prize, int count) {
        String formatMessage = String.format(
                Message.MATCH_RESULT.getMessage(),
                matchCount,
                prize,
                count
        );
        System.out.println(formatMessage);
    }

    public void printTotalStaticResult(double totalStatic) {
        String formatMessage = String.format(
                Message.TOTAL_RESULT.getMessage(),
                totalStatic
        );
        System.out.println(formatMessage);
    }
}

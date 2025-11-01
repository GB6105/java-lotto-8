package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.constant.Message;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputView {

    private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

    public void printRequirePriceMessage() {
        System.out.println(Message.REQUIRE_PRICE.getMessage());
    }

    public void printRequireWinningNumberMessage() {
        System.out.println();
        System.out.println(Message.REQUIRE_LOTTO.getMessage());
    }

    public void printRequireBonusNumberMessage() {
        System.out.println();
        System.out.println(Message.REQUIRE_BONUS_NUMBER.getMessage());
    }

    public void printPurchaseMessage(int count){
        System.out.println();
        String formatString = String.format(
                Message.PURCHASE_MESSAGE.getMessage(),
                count
        );
        System.out.println(formatString);
    }

    public void printLottos(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.getNumbers());
        }
    }


    public void printTotalResult(LottoResult result){
        System.out.println();
        printResult();
        printMatchResultMessage(result.getMatchCounts());
        printProfitRateResult(result.getProfitRate());
    }

    private void printResult(){
        System.out.println(Message.RESULT_MESSAGE.getMessage());
        System.out.println("---");
    }

    private void printMatchResult(int matchCount, int prize, int count) {
        String formatPrize = numberFormat.format(prize);
        String formatMessage = String.format(
                Message.MATCH_RESULT.getMessage(),
                matchCount,
                formatPrize,
                count
        );
        System.out.println(formatMessage);
    }

    private void printMatchBonusResult(int matchCount, int prize, int count) {
        String formatPrize = numberFormat.format(prize);
        String formatMessage = String.format(
                Message.MATCH_BONUS_RESULT.getMessage(),
                matchCount,
                formatPrize,
                count
        );
        System.out.println(formatMessage);
    }

    private void printMatchResultMessage(Map<Rank,Integer> matchResult) {

        List<Rank> ranks = Arrays.asList(Rank.values());

        Collections.sort(ranks, Comparator.comparing(Rank::getRank).reversed());

        for(Rank rank : ranks) {
            if(rank == Rank.NONE){
                continue;
            }
            int count = matchResult.get(rank);
            int matchCount = rank.getMatchingCount();
            int prize = rank.getPrize();
            boolean isBonus = rank.isBonus();

            if(isBonus){
                printMatchBonusResult(matchCount, prize, count);
            }

            if(!isBonus){
                printMatchResult(matchCount, prize, count);
            }
        }

    }

    private void printProfitRateResult(double profitRate) {
        String formatMessage = String.format(
                Message.TOTAL_RESULT.getMessage(),
                profitRate
        );
        System.out.println(formatMessage);
    }
}

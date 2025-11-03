package lotto.domain;

import java.util.Map;
import lotto.constant.Rank;

public class LottoResult {
    private final Map<Rank, Integer> matchCounts;
    private final double profitRate;

    public LottoResult(Map<Rank, Integer> matchCounts, double priceAmount) {
        this.matchCounts = matchCounts;
        this.profitRate = calculateProfitRate(priceAmount);
    }


    public Map<Rank, Integer> getMatchCounts() {
        return matchCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }

    private double calculateProfitRate(double priceAmount) {
        long totalPrize = calculateTotalPrize();
        if (totalPrize == 0) {
            return 0.0;
        }

        return (double) totalPrize / priceAmount *100 ;
    }

    private long calculateTotalPrize() {
        long totalPrize = matchCounts.entrySet().
                stream()
                .mapToLong(this::calculateEachPrize)
                .sum();
        return totalPrize;
    }

    private long calculateEachPrize(Map.Entry<Rank, Integer> entry) {
        long prize = entry.getKey().getPrize();
        int count = entry.getValue();
        return prize * count;
    }
}

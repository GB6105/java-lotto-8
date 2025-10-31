package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST(1, false, 2000000000, 6),
    SECOND(2, true, 30000000, 5),
    THIRD(3, false, 1500000, 5),
    FOURTH(4, false, 50000,4),
    FIFTH(5, false, 5000, 3),
    NONE(0,false,0,0);

    Rank(int rank, boolean isBonus, int prize, int matchingCount){
        this.rank = rank;
        this.isBonus = isBonus;
        this.prize = prize;
        this.matchingCount = matchingCount;
    }
    private final int rank;
    private final boolean isBonus;
    private final int prize;
    private final int matchingCount;

    public static Rank of(int matchingCount, boolean hasBonus){
        if(matchingCount < 3){
            return NONE;
        }

        return Arrays.stream(values())
                .filter(rank -> rank != NONE)
                .filter(rank -> rank.matchingCount == matchingCount)
                .filter(rank -> {
                    if(matchingCount == 5){
                        return rank.isBonus == hasBonus;
                    }
                    return true;
                })
                .findFirst()
                .orElse(NONE);
    }

}

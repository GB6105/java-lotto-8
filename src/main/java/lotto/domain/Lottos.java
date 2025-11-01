package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Rank;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<Lotto>(lottos);
    }

    public Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public static Lottos createEmpty() {
        return new Lottos(new ArrayList<>());
    }

    public Lottos add(Lotto lotto) {
        List<Lotto> newLotto = new ArrayList<>(this.lottos);
        newLotto.add(lotto);
        return new Lottos(newLotto);
    }

    public Map<Rank, Integer> match(WinningNumbers winningNumbers) {
        Map<Rank, Integer> matchCounts = new EnumMap<>(Rank.class);

        for(Rank rank : Rank.values()) {
            matchCounts.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(
                    winningNumbers
            );
            if(rank != Rank.NONE) {
                matchCounts.put(rank, matchCounts.get(rank) + 1);
            }
        }
        return matchCounts;
    }
}

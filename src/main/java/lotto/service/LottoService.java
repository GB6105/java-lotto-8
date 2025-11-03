package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class LottoService {
    private final LottoGenerator generator;

    public LottoService(LottoGenerator generator) {
        this.generator = generator;
    }

    // 구매 금액에 따라 로또 생성
    public Lottos purchaseLottos(int price){
        int purchasedCount = price / 1000;
        Lottos customerLottos = Lottos.createEmpty();
        for (int i = 0; i < purchasedCount; i++) {
            List<Integer> numbers = generator.generate();
            Lotto lotto = new Lotto(numbers);
            customerLottos = customerLottos.add(lotto);
        }
        return customerLottos;
    }

    // 로또 매칭 결과 반환
    public LottoResult checkLottos(Lottos lottos, WinningNumbers winningNumbers, int price){
        Map<Rank, Integer> matchCount = lottos.match(winningNumbers);
        LottoResult result = new LottoResult(matchCount, price);
        return result;
    }
}

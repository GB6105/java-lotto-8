package lotto.service;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.presentation.Reader;
import lotto.presentation.OutputView;

public class LottoGame {
    private Reader reader;
    private OutputView outputView;
    private LottoService lottoService;

    public LottoGame(Reader reader, OutputView outputView, LottoService lottoService) {
        this.reader = reader;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        // 구매 금액 입력
        int price = reader.getPrice();

        //로또 구입
        Lottos lottos = lottoService.purchaseLottos(price);
        outputView.printPurchaseMessage(price / 1000);
        outputView.printLottos(lottos);

        // 당첨 번호 입력
        List<Integer> winningNumber = reader.getWinningNumber();

        // 보너스 번호 입력
        int bonusNumber = reader.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);

        //결과 출력
        LottoResult result = lottoService.checkLottos(lottos,winningNumbers,price);
        outputView.printTotalResult(result);
    }

}

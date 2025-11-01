package lotto.application;

import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputController inputController;
    private OutputView outputView;
    private LottoService lottoService;

    public LottoController(InputController inputController, OutputView outputView, LottoService lottoService) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        // 구매 금액 입력
        int price = inputController.getPrice();

        //로또 구입
        Lottos lottos = lottoService.purchaseLottos(price);
        outputView.printPurchaseMessage(price / 1000);
        outputView.printLottos(lottos);

        // 당첨 번호 입력
        List<Integer> winningNumber = inputController.getWinningNumber();

        // 보너스 번호 입력
        int bonusNumber = inputController.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);

        //결과 출력
        LottoResult result = lottoService.checkLottos(lottos,winningNumbers,price);
        outputView.printTotalResult(result);
    }

}

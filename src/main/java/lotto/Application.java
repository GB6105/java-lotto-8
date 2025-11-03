package lotto;

import lotto.infrastructure.NumberGenerator;
import lotto.presentation.Reader;
import lotto.service.LottoGame;
import lotto.service.LottoService;
import lotto.presentation.InputView;
import lotto.presentation.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Reader reader = new Reader(inputView,outputView);
        NumberGenerator generator = new NumberGenerator();
        LottoService lottoService = new LottoService(generator);
        LottoGame lottoGame = new LottoGame(reader, outputView, lottoService);

        lottoGame.run();

    }
}

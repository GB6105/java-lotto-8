package lotto;

import lotto.application.InputController;
import lotto.application.LottoController;
import lotto.application.LottoService;
import lotto.domain.LottoGenerator;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();
        InputController inputController = new InputController(inputView,outputView,parser);
        LottoGenerator generator = new LottoGenerator();
        LottoService lottoService = new LottoService(generator);
        LottoController controller = new LottoController(inputController, outputView, lottoService);

        controller.run();

    }
}

package lotto.application;

import java.util.List;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {
    private InputView inputView;
    private OutputView outputView;
    private Parser parser;

    public InputController(InputView inputView, OutputView outputView, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
    }

    public int getBonusNumber() {
        while (true) {
            try {
                outputView.printRequireBonusNumberMessage();
                String bonusNumberInput = inputView.readBonusNumber();
                int bonusNumber = parser.number(bonusNumberInput);
                Validator.validateNumberRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumber() {
        while (true) {
            try {
                outputView.printRequireWinningNumberMessage();
                String winningNumberInput = inputView.readNumbers();
                List<Integer> winningNumber = parser.numbers(winningNumberInput);
                Validator.validateNumbersRange(winningNumber);
                Validator.validateNumbersSize(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getPrice() {
        while (true) {
            try {
                outputView.printRequirePriceMessage();
                String priceInput = inputView.readPrice();
                int price = parser.number(priceInput);
                Validator.validatePriceRange(price);
                Validator.validatePriceUnit(price);
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

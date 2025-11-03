package lotto.presentation;

import java.util.List;
import lotto.util.Parser;
import lotto.util.Validator;

public class Reader {
    private InputView inputView;
    private OutputView outputView;

    public Reader(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int getBonusNumber() {
        while (true) {
            try {
                outputView.printRequireBonusNumberMessage();
                String bonusNumberInput = inputView.readBonusNumber();
                int bonusNumber = Parser.number(bonusNumberInput);
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
                List<Integer> winningNumber = Parser.numbers(winningNumberInput);
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
                int price = Parser.number(priceInput);
                Validator.validatePriceRange(price);
                Validator.validatePriceUnit(price);
                return price;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

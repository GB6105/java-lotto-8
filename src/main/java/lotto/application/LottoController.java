package lotto;

import java.util.List;
import lotto.domain.Checker;
import lotto.domain.RandomNumber;
import lotto.domain.RandomNumbers;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;

public class LottoController {
    public void run(){
        InputView inputView = new InputView();
        Parser parser = new Parser();

        String priceInput = inputView.readPrice();
        int price = parser.price(priceInput);
        Validator.validatePriceRange(price);
        int amount = parser.getPurchaseAmount(price);

        String targetNumberInput = inputView.readNumbers();
        List<Integer> targetNumber = parser.targetNumber(targetNumberInput);
        Validator.validateNumbersRange(targetNumber);

        String bonusNumber = inputView.readBonusNumber();
        int bonusNumberInt = parser.bonusNumber(bonusNumber);
        Validator.validateNumberRange(bonusNumberInt);

        RandomNumbers randomNumbers = new RandomNumbers(amount);
        Checker checker = new Checker(randomNumbers,targetNumber,bonusNumberInt);


    }
}

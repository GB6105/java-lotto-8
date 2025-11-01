package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerLottos {
    private List<Lotto> lottos;

    public CustomerLottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<Lotto>(lottos);
    }

    public CustomerLottos from(List<Lotto> lottos) {
        return new CustomerLottos(lottos);
    }

    public static CustomerLottos createEmpty(){
        return new CustomerLottos(new ArrayList<>());
    }

    public CustomerLottos add(Lotto lotto) {
        List<Lotto> newLotto = new ArrayList<>(this.lottos);
        newLotto.add(lotto);
        return new CustomerLottos(newLotto);
    }


}

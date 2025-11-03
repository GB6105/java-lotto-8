package lotto.domain;

import java.util.List;

// 위치가 domain인 것 안좋음
// -> infrastructure로
public interface LottoGenerator {
    List<Integer> generate();
}

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private final RandomNumberGenerator generator = new RandomNumberGenerator();

    @DisplayName("랜덤 숫자는 0 이상 9 이하의 범위에서 생성되어야 한다.")
    @RepeatedTest(100)
    void numberIsWithinRangeWhenGenerated() {
        int number = generator.generate();

            assertThat(number)
                .isGreaterThanOrEqualTo(MIN_NUMBER)
                .isLessThanOrEqualTo(MAX_NUMBER);
    }
}

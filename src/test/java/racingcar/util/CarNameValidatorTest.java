package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarNameValidatorTest {

    private static final String BELOW_MIN_COUNT_ERROR_MESSAGE = "자동차 수는 2개 이상이어야 합니다.";
    private static final String ABOVE_MAX_COUNT_ERROR_MESSAGE = "자동차 수는 10개 이하여야 합니다.";

    @Test
    @DisplayName("모든 자동차 이름이 유효하면 통과한다.")
    void validCarNamePass() {
        List<String> names = List.of("pobi", "woni", "jun");

        assertThatCode(() -> CarNameValidator.validate(names))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 개수가 최소값이면 성공한다.")
    void validateMinCarCountPass() {
        List<String> MIN_COUNT_NAMES = List.of("1", "2");

        assertThatCode(() -> CarNameValidator.validate(MIN_COUNT_NAMES))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 개수가 최대값이면 성공한다.")
    void validateMaxCarCountPass() {
        List<String> MAX_COUNT_NAMES = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        assertThatCode(() -> CarNameValidator.validate(MAX_COUNT_NAMES))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 개수가 최소값 미만이면 예외를 발생시킨다.")
    void throwExceptionWhenBelowMinCarCount() {
        List<String> carNames = List.of("1");

        assertThatThrownBy(() -> CarNameValidator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BELOW_MIN_COUNT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 개수가 최대값 초과이면 예외를 발생시킨다.")
    void throwWhenAboveMaxCarCount() {
        List<String> carNames = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        assertThatThrownBy(() -> CarNameValidator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ABOVE_MAX_COUNT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다.")
    void throwExceptionWhenNameTooLong() {
        List<String> names = List.of("pobi", "woniiii");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복 입력되면 예외를 발생시킨다.")
    void throwExceptionWhenDuplicateNames() {
        List<String> names = List.of("pobi", "pobi", "woni");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외를 발생시킨다.")
    void throwExceptionWhenNameIsNull() {
        List<String> names = null;

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 비어 있을 수 없습니다.");
    }
    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외를 발생시킨다")
    void throwExceptionWhenNameIsEmpty() {
        List<String> names = List.of("pobi", "");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외를 처리한다.")
    void throwExceptionWhenNameIsBlank() {
        List<String> names = List.of("pobi", " ");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백일 수 없습니다.");
    }
}

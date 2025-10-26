package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessages.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarNameValidatorTest {

    @Test
    @DisplayName("모든 자동차 이름이 유효하면 통과한다")
    void 모든_자동차_이름이_유효하면_통과한다() {
        List<String> names = List.of("pobi", "woni", "jun");

        assertThatCode(() -> CarNameValidator.validate(names))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 개수가 최소값이면 성공한다")
    void 자동차_이름_개수가_최소값이면_성공한다() {
        List<String> MIN_COUNT_NAMES = List.of("1", "2");

        assertThatCode(() -> CarNameValidator.validate(MIN_COUNT_NAMES))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 개수가 최대값이면 성공한다")
    void 자동차_이름_개수가_최대값이면_성공한다() {
        List<String> MAX_COUNT_NAMES = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        assertThatCode(() -> CarNameValidator.validate(MAX_COUNT_NAMES))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 개수가 최소값 미만이면 예외를 발생시킨다")
    void 자동차_이름_개수가_최소값_미만이면_예외를_발생시킨다() {
        List<String> carNames = List.of("1");

        assertThatThrownBy(() -> CarNameValidator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_COUNT_BELOW_MIN_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 개수가 최대값 초과이면 예외를 발생시킨다")
    void 자동차_이름_개수가_최대값_초과이면_예외를_발생시킨다() {
        List<String> carNames = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        assertThatThrownBy(() -> CarNameValidator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_COUNT_ABOVE_MAX_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다")
    void 자동차_이름이_5자를_초과하면_예외를_발생시킨다() {
        List<String> names = List.of("pobi", "woniiii");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_EXCEEDED_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름이 중복 입력되면 예외를 발생시킨다")
    void 자동차_이름이_중복_입력되면_예외를_발생시킨다() {
        List<String> names = List.of("pobi", "pobi", "woni");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외를 발생시킨다")
    void 자동차_이름이_null이면_예외를_발생시킨다() {
        List<String> names = null;

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_INPUT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외를 발생시킨다")
    void 자동차_이름이_빈_문자열이면_예외를_발생시킨다() {
        List<String> names = List.of("pobi", "");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외를 발생시킨다")
    void 자동차_이름이_공백이면_예외를_발생시킨다() {
        List<String> names = List.of("pobi", " ");

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_NAME_ERROR_MESSAGE);
    }
}

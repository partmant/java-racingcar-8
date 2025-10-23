package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    @Test
    @DisplayName("모든 자동차 이름이 유효하면 통과한다.")
    void validCarNamePass() {
        String[] names = {"pobi", "woni"};

        assertThatCode(() -> CarNameValidator.validate(names))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다.")
    void throwExceptionWhenNameTooLong() {
        String[] names = {"pobi", "woniiii"};

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복 입력되면 예외를 발생시킨다.")
    void throwExceptionWhenDuplicateNames() {
        String[] names = {"pobi", "pobi", "woni"};

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외를 발생시킨다.")
    void throwExceptionWhenNameIsNull() {
        String[] names = null;

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 비어 있을 수 없습니다.");
    }
    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외를 발생시킨다")
    void throwExceptionWhenNameIsEmpty() {
        String[] names = {"pobi", ""};

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외를 처리한다.")
    void throwExceptionWhenNameIsBlank() {
        String[] names = {"pobi", " "};

        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백일 수 없습니다.");
    }
}

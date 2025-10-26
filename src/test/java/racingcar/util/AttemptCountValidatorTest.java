package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptCountValidatorTest {

    private static final String MIN_COUNT = "1";
    private static final String MAX_COUNT = "10";
    private static final String BELOW_MIN_COUNT = "0";
    private static final String ABOVE_MAX_COUNT = "11";

    private static final String BELOW_MIN_ERROR_MESSAGE = "이동 횟수는 1 이상의 정수여야 합니다.";
    private static final String ABOVE_MAX_ERROR_MESSAGE = "이동 횟수는 10 이하의 정수여야 합니다.";

    @Test
    @DisplayName("이동 횟수가 최소 허용값이면 성공한다")
    void 이동_횟수가_최소_허용값이면_성공한다() {
        assertThatCode(() -> AttemptCountValidator.validate(MIN_COUNT))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이동 횟수가 최대 허용값이면 성공한다")
    void 이동_횟수가_최대_허용값이면_성공한다() {
        assertThatCode(() -> AttemptCountValidator.validate(MAX_COUNT))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이동 횟수가 허용 범위 내의 값이면 성공한다")
    void 이동_횟수가_허용_범위_내의_값이면_성공한다() {
        assertThatCode(() -> AttemptCountValidator.validate("5"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이동 횟수가 최소값 미만이면 예외를 발생시킨다")
    void 이동_횟수가_최소값_미만이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> AttemptCountValidator.validate(BELOW_MIN_COUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BELOW_MIN_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("이동 횟수가 최대값 초과이면 예외를 발생시킨다")
    void 이동_횟수가_최대값_초과이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> AttemptCountValidator.validate(ABOVE_MAX_COUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ABOVE_MAX_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("입력이 null이면 예외를 발생시킨다")
    void 입력이_null이면_예외를_발생시킨다() {
        String attemptCount = null;

        assertThatThrownBy(() -> AttemptCountValidator.validate(attemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 null일 수 없습니다.");
    }

    @Test
    @DisplayName("입력이 빈 문자열이면 예외를 발생시킨다")
    void 입력이_빈_문자열이면_예외를_발생시킨다() {
        String attemptCount = "";

        assertThatThrownBy(() -> AttemptCountValidator.validate(attemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("입력이 숫자가 아니면 예외를 발생시킨다")
    void 입력이_숫자가_아니면_예외를_발생시킨다() {
        String attemptCount = "a4";

        assertThatThrownBy(() -> AttemptCountValidator.validate(attemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 숫자여야 합니다.");
    }
}

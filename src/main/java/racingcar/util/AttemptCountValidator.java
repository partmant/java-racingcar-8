package racingcar.util;

public class AttemptCountValidator {

    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final int MAX_ATTEMPT_COUNT = 10;

    private AttemptCountValidator() {
    }

    public static int validate(String input) {
        validateNull(input);
        validateEmpty(input);

        int attemptCount = parseInteger(input);
        validateRange(attemptCount);

        return attemptCount;
    }

    private static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력은 null일 수 없습니다.");
        }
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력은 비어 있을 수 없습니다.");
        }
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateRange(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("이동 횟수는 1 이상의 정수여야 합니다.");
        }
        if (attemptCount > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("이동 횟수는 10 이하의 정수여야 합니다.");
        }
    }
}

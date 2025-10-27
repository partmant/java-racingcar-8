package racingcar.util;

import static racingcar.exception.ErrorMessages.*;

public final class AttemptCountValidator {

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
            throw new IllegalArgumentException(NULL_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private static void validateRange(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ATTEMPT_BELOW_MIN_ERROR_MESSAGE);
        }
        if (attemptCount > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ATTEMPT_ABOVE_MAX_ERROR_MESSAGE);
        }
    }
}

package racingcar.util;

import static racingcar.exception.ErrorMessages.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    private static final int MAX_NAME_LENGTH = 5;

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_COUNT = 10;

    private CarNameValidator() {
    }

    public static void validate(List<String> carNames) {
        validateNotEmpty(carNames);
        validateCount(carNames);
        validateDuplicateNames(carNames);
        validateEachName(carNames);
    }

    private static void validateNotEmpty(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateCount(List<String> carNames) {
        int carCount = carNames.size();
        if (carCount < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_BELOW_MIN_ERROR_MESSAGE);
        }
        if (carCount > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ABOVE_MAX_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicateNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
            }
        }
    }

    private static void validateEachName(List<String> carNames) {
        for (String name : carNames) {
            validateSingleName(name);
        }
    }

    private static void validateSingleName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_ERROR_MESSAGE);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEEDED_ERROR_MESSAGE);
        }
    }
}

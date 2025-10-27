package racingcar.util;

import static racingcar.exception.ErrorMessages.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CarNameValidator {

    private static final int MAX_NAME_LENGTH = 5;

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_COUNT = 10;

    private CarNameValidator() {
    }

    public static void validate(List<String> carNames) {
        validateNullInput(carNames);
        validateEmptyList(carNames);
        validateCount(carNames);
        validateDuplicateNames(carNames);
        validateAllNames(carNames);
    }

    private static void validateNullInput(List<String> carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateEmptyList(List<String> carNames) {
        if (carNames.isEmpty()) {
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

    private static void validateAllNames(List<String> carNames) {
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

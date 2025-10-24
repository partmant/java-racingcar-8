package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    private static final int MAX_NAME_LENGTH = 5;

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_COUNT = 10;

    private CarNameValidator() {
    }

    public static void validate(String[] carNames) {
        validateNotEmpty(carNames);
        validateCount(carNames);
        validateDuplicateNames(carNames);
        validateEachName(carNames);
    }

    private static void validateNotEmpty(String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("입력은 비어 있을 수 없습니다.");
        }
    }

    private static void validateCount(String[] carNames) {
        int carCount = carNames.length;
        if (carCount < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 수는 2개 이상이어야 합니다.");
        }
        if (carCount > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 수는 10개 이하여야 합니다.");
        }
    }

    private static void validateDuplicateNames(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }
        }
    }

    private static void validateEachName(String[] carNames) {
        for (String name : carNames) {
            validateSingleName(name);
        }
    }

    private static void validateSingleName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}

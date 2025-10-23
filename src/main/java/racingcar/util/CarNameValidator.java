package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    private static final int MAX_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static void validate(String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("입력은 비어 있을 수 없습니다.");
        }

        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            validateSingleName(name);

            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }
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

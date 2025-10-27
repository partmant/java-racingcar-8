package racingcar.util;

import java.util.Arrays;
import java.util.List;

public final class CarNameParser {

    private CarNameParser() {
    }

    public static List<String> splitCarName(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}

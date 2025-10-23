package racingcar.util;

import java.util.Arrays;

public class CarNameParser {

    private CarNameParser() {
    }

    public static String[] splitCarName(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }
}

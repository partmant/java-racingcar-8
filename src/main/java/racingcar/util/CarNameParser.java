package racingcar.util;

public class CarNameParser {

    public static String[] splitCarName(String input) {

        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }

        return carNames;
    }
}

package racingcar.io;

import racingcar.domain.Cars;
import racingcar.util.AttemptCountValidator;
import racingcar.util.CarNameParser;
import racingcar.util.CarNameValidator;
import racingcar.view.InputView;

import java.util.List;

public class InputHandler {

    public Cars getCarsFromUser() {
        String inputNames = readCarNames();
        List<String> carNames = parseCarNames(inputNames);
        validateCarNames(carNames);
        return createCars(carNames);
    }

    public int getAttemptCountFromUser() {
        String inputAttempt = readAttemptCount();
        return validateAttemptCount(inputAttempt);
    }

    private String readCarNames() {
        return InputView.readCarNames();
    }

    private List<String> parseCarNames(String inputNames) {
        return CarNameParser.splitCarName(inputNames);
    }

    private void validateCarNames(List<String> carNames) {
        CarNameValidator.validate(carNames);
    }

    private Cars createCars(List<String> carNames) {
        return Cars.create(carNames);
    }

    private String readAttemptCount() {
        return InputView.readAttemptCount();
    }

    private int validateAttemptCount(String inputAttempt) {
        return AttemptCountValidator.validate(inputAttempt);
    }
}

package racingcar.io;

import racingcar.domain.Cars;
import racingcar.util.AttemptCountValidator;
import racingcar.util.CarNameParser;
import racingcar.util.CarNameValidator;
import racingcar.view.InputView;

import java.util.List;

public class InputHandler {

    public Cars getCarsFromUser() {
        String inputNames = InputView.readCarNames();
        List<String> carNames = CarNameParser.splitCarName(inputNames);
        CarNameValidator.validate(carNames);
        return Cars.create(carNames);
    }

    public int getAttemptCountFromUser() {
        String inputAttempt = InputView.readAttemptCount();
        return AttemptCountValidator.validate(inputAttempt);
    }
}

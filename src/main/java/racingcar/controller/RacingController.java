package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.util.AttemptCountValidator;
import racingcar.util.CarNameParser;
import racingcar.util.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final RacingService racingService;

    private RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public static RacingController of(RacingService racingService) {
        return new RacingController(racingService);
    }

    public void run() {
        Cars cars = initializeCars();
        int attemptCount = readAttemptCount();
        executeRaceRounds(cars, attemptCount);
        displayFinalResults(cars);
    }

    private Cars initializeCars() {
        List<String> carNames = readCarNames();
        return Cars.create(carNames);
    }

    private List<String> readCarNames() {
        String inputNames = InputView.readCarNames();
        List<String> carNames = CarNameParser.splitCarName(inputNames);
        CarNameValidator.validate(carNames);
        return carNames;
    }

    private int readAttemptCount() {
        String inputAttempt = InputView.readAttemptCount();
        return AttemptCountValidator.validate(inputAttempt);
    }

    private void executeRaceRounds(Cars cars, int attemptCount) {
        OutputView.printResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            playSingleRound(cars);
        }
    }

    private void playSingleRound(Cars cars) {
        racingService.startRound(cars);
        OutputView.printRoundResult(cars.getCarNames(), cars.getPositions());
    }

    private void displayFinalResults(Cars cars) {
        OutputView.printWinners(cars.getWinners());
    }
}

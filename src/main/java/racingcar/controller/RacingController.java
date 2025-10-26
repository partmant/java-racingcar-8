package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.util.AttemptCountValidator;
import racingcar.util.CarNameParser;
import racingcar.util.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        Cars cars = initializeCars();
        int attemptCount = readAttemptCount();

        executeRaceRounds(cars, attemptCount);
        displayFinalResults(cars);
    }

    private Cars initializeCars() {
        String inputNames = inputView.readCarNames();
        List<String> carNames = CarNameParser.splitCarName(inputNames);
        CarNameValidator.validate(carNames);

        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }

    private int readAttemptCount() {
        String inputAttempt = inputView.readAttemptCount();
        return AttemptCountValidator.validate(inputAttempt);
    }

    private void executeRaceRounds(Cars cars, int attemptCount) {
        outputView.appendResultMessage();

        for (int round = 0; round < attemptCount; round++) {
            racingService.startRace(cars, 1);
            outputView.appendRoundResult(cars.getCarNames(), cars.getPositions());
        }
    }

    private void displayFinalResults(Cars cars) {
        List<String> winners = cars.getWinners();
        outputView.appendWinners(winners);
        outputView.printAll();
    }
}

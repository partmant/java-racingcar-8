package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.service.RacingService;

public class RacingController {

    private final InputHandler inputHandler;
    private final RaceManager raceManager;

    private RacingController(InputHandler inputHandler, RaceManager raceManager) {
        this.inputHandler = inputHandler;
        this.raceManager = raceManager;
    }

    public static RacingController of(RacingService racingService) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        RaceManager raceManager = new RaceManager(racingService, outputHandler);
        return new RacingController(inputHandler, raceManager);
    }

    public void run() {
        Cars cars = inputHandler.getCarsFromUser();
        int attemptCount = inputHandler.getAttemptCountFromUser();
        raceManager.runRace(cars, attemptCount);
    }
}

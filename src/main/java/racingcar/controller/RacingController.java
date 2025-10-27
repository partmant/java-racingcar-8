package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class RacingController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RaceManager raceManager;

    private RacingController(InputHandler inputHandler, OutputHandler outputHandler, RaceManager raceManager) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.raceManager = raceManager;
    }

    public static RacingController of(RacingService racingService) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        RaceManager raceManager = new RaceManager(racingService, outputHandler);
        return new RacingController(inputHandler, outputHandler, raceManager);
    }

    public void run() {
        Cars cars = inputHandler.getCarsFromUser();
        int attemptCount = inputHandler.getAttemptCountFromUser();
        raceManager.runRace(cars, attemptCount);
    }
}

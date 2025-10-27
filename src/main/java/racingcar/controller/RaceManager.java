package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.io.OutputHandler;

public class RaceManager {

    private final RacingService racingService;
    private final OutputHandler outputHandler;

    public RaceManager(RacingService racingService, OutputHandler outputHandler) {
        this.racingService = racingService;
        this.outputHandler = outputHandler;
    }

    public void runRace(Cars cars, int attemptCount) {
        outputHandler.printResultHeader();

        for (int round = 0; round < attemptCount; round++) {
            racingService.startRound(cars);
            outputHandler.printRoundResult(cars);
        }

        outputHandler.printFinalWinners(cars);
    }
}

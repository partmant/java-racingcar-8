package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.io.OutputHandler;
import racingcar.service.RacingService;

public class RaceManager {

    private final RacingService racingService;
    private final OutputHandler outputHandler;

    public RaceManager(RacingService racingService, OutputHandler outputHandler) {
        this.racingService = racingService;
        this.outputHandler = outputHandler;
    }

    public void runRace(Cars cars, int attemptCount) {
        printHeader();
        executeRounds(cars, attemptCount);
        printFinal(cars);
    }

    private void printHeader() {
        outputHandler.printResultHeader();
    }

    private void executeRounds(Cars cars, int attemptCount) {
        for (int round = 0; round < attemptCount; round++) {
            playSingleRound(cars);
        }
    }

    private void playSingleRound(Cars cars) {
        racingService.startRound(cars);
        outputHandler.printRoundResult(cars);
    }

    private void printFinal(Cars cars) {
        outputHandler.printFinalWinners(cars);
    }
}

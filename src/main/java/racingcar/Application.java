package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        initController().run();
    }

    private static RacingController initController() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        Race race = new Race(numberGenerator);
        RacingService racingService = new RacingService(race);
        return RacingController.of(racingService);
    }
}

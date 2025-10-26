package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        Race race = new Race(numberGenerator);
        RacingService racingService = new RacingService(race);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingController controller = new RacingController(inputView, outputView, racingService);
        controller.run();
    }
}

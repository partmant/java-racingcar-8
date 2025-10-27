package racingcar.io;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class OutputHandler {

    public void printResultHeader() {
        OutputView.printResultHeader();
    }

    public void printRoundResult(Cars cars) {
        OutputView.printRoundResult(cars.getCarNames(), cars.getPositions());
    }

    public void printFinalWinners(Cars cars) {
        OutputView.printFinalWinners(cars.getWinners());
    }
}

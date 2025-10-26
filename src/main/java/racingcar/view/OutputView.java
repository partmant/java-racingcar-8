package racingcar.view;

import java.util.List;

public final class OutputView {

    private OutputView() {}

    public static void printResultMessage() {
        System.out.print(OutputMessageFormatter.buildResultMessage());
    }

    public static void printRoundResult(List<String> carNames, List<Integer> positions) {
        System.out.print(OutputMessageFormatter.buildRoundResult(carNames, positions));
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.print(OutputMessageFormatter.buildWinners(winnerNames));
    }
}

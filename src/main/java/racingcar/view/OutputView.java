package racingcar.view;

import java.util.List;

public final class OutputView {

    private OutputView() {}

    public static void printResultHeader() {
        System.out.print(OutputMessageFormatter.formatResultTitle());
    }

    public static void printRoundResult(List<String> carNames, List<Integer> positions) {
        System.out.print(ResultMessageAssembler.assembleRoundResult(carNames, positions));
    }

    public static void printFinalWinners(List<String> winnerNames) {
        System.out.print(ResultMessageAssembler.assembleFinalWinners(winnerNames));
    }
}

package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ResultMessageAssembler {

    private static final String WINNER_SEPARATOR = ", ";

    private ResultMessageAssembler() {}

    public static String assembleRoundResult(List<String> carNames, List<Integer> positions) {
        String roundResult = IntStream.range(0, carNames.size())
                .mapToObj(i -> OutputMessageFormatter.formatCarProgress(carNames.get(i), positions.get(i)))
                .collect(Collectors.joining("\n"));
        return roundResult + "\n\n";
    }

    public static String assembleFinalWinners(List<String> winnerNames) {
        String joined = String.join(WINNER_SEPARATOR, winnerNames);
        return OutputMessageFormatter.formatWinnerNames(joined);
    }
}

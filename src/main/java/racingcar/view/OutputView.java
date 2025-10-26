package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    private static final String DISTANCE_SYMBOL = "-";

    private final StringBuilder outputBuilder = new StringBuilder();

    public void printResultMessage() {
        outputBuilder.append("\n실행 결과\n");
    }

    public void printRoundResult(List<String> carNames, List<Integer> positions) {
        IntStream.range(0, carNames.size())
                .forEach(i -> {
                    String line = carNames.get(i) + " : " + DISTANCE_SYMBOL.repeat(positions.get(i)) + "\n";
                    outputBuilder.append(line);
                });
        outputBuilder.append("\n");
    }

    public String getOutputResult() {
        return outputBuilder.toString();
    }
}

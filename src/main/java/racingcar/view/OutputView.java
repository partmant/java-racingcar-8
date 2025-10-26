package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String WINNER_SEPARATOR = ", ";

    private final StringBuilder outputBuilder = new StringBuilder();

    public void appendResultMessage() {
        outputBuilder.append("\n실행 결과\n");
    }

    public void appendRoundResult(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            outputBuilder.append(carNames.get(i))
                    .append(" : ")
                    .append(DISTANCE_SYMBOL.repeat(positions.get(i)))
                    .append("\n");
        }
        outputBuilder.append("\n");
    }

    public void appendWinners(List<String> winnerNames) {
        String winners = String.join(WINNER_SEPARATOR, winnerNames);
        outputBuilder.append("최종 우승자 : ").append(winners).append("\n");
    }

    public void printAll() {
        System.out.print(outputBuilder.toString());
    }
}
